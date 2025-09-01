import {Button, Card, CardBody, CardFooter} from '@heroui/react'
import DashboardCard from '../../components/DashboardCard';
import DataAcknowledge from '../../components/DashboardCardContent/DataAcknowledge';

const Home = () => {
    return(
        <div className='w-full h-full grid grid-cols-2 grid-rows-3 md:grid-cols-3 lg:grid-cols-3 gap-4 col-span-2 row-span-3 '>
            <DashboardCard id='avg daily intake' className='text-4xl font-light md:col-span-2'>
                Intake
            </DashboardCard>

            <DashboardCard id='percentages'>
                Body Composition
            </DashboardCard>

            <DashboardCard id='Basic' className='row-span-2'>
                BMI
            </DashboardCard>

            <DashboardCard id='wlgr wlgx' className='md:col-span-2'>
                WLGR & WLGX
            </DashboardCard>

            <DashboardCard id='sleeping duration'>
                Sleeping
            </DashboardCard>

            <DashboardCard id='data acknowledge'>
                <DataAcknowledge />
            </DashboardCard>
        </div>
    )
}

export default Home;