import { Clock } from 'lucide-react';
// import background from '../../assets/DataAcknowledgeBG.png'
const DataAcknowledge = () => {
    return (
        <div className="inset-0 absolute w-full h-full p-8">
            <div className="-z-10 inset-0 absolute w-full h-full overflow-clip">
                {/* <img src={background} className='w-full h-full object-cover object-bottom'/> */}
                <Clock className='-rotate-20 absolute stroke-indigo-500 w-50 h-50 opacity-10 -right-3 -bottom-3 drop-shadow-lg/50'/>
            </div>
            <div className='flex w-full h-full flex-col justify-between'>
                <h1 className="text-3xl">
                    Data Sourced
                </h1>
                <div>
                    <h2>
                        From 21st August
                    </h2>
                    <h2>
                        To 28th August
                    </h2>
                </div>
            </div>
        </div>
    )
};

export default DataAcknowledge;