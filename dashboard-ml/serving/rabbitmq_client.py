import pika
import json
import os

class RabbitMQClient:
    def __init__(self, host=None, port=None, username=None, password=None, virtual_host=None):
        self.host = host or os.getenv('ML_RABBITMQ_HOST', 'localhost')
        self.port = int(port or os.getenv('ML_RABBITMQ_PORT', 5672))
        self.username = username or os.getenv('ML_RABBITMQ_USERNAME', 'guest')
        self.password = password or os.getenv('ML_RABBITMQ_PASSWORD', 'guest')
        self.virtual_host = virtual_host or os.getenv('ML_RABBITMQ_DEFAULT_VHOST', '/')

        self.credentials = pika.PlainCredentials(self.username, self.password)
        self.parameters = pika.ConnectionParameters(
            host=self.host,
            port=self.port,
            credentials=self.credentials,
            virtual_host=self.virtual_host,
            heartbeat=600,
            blocked_connection_timeout=300
        )

        self.connection = None
        self.channel = None
        self._connect()

    def _connect(self):
        try:
            self.connection = pika.BlockingConnection(self.parameters)
            self.channel = self.connection.channel()
        except Exception as e:
            raise

    def declare_queue(self, queue_name, durable=True):
        self.channel.queue_declare(queue=queue_name, durable=durable)

    def consume(self, queue_name, callback, prefetch_count=1):
        self.channel.basic_qos(prefetch_count=prefetch_count)
        self.channel.basic_consume(
            queue=queue_name,
            on_message_callback=callback,
            auto_ack=False
        )

        try:
            self.channel.start_consuming()
        except:
            self.channel.stop_consuming()
        
    def publish(self, queue_name, message, persistent=True):
        message = json.dumps(message)

        properties = pika.BasicProperties(
            delivery_mode=2 if persistent else 1,
            content_type='application/json'
        )

        self.channel.basic_publish(
            exchange='',
            routing_key=queue_name,
            body=message,
            properties=properties
        )
    
    def close(self):
        if self.connection and not self.connection.is_closed:
            self.connection.close()