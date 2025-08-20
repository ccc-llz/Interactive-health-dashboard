import { Button } from '@heroui/react'
import { Cog, Gauge, CircleQuestionMark, ChartLine } from 'lucide-react'
import SidebarMenuItem from './SidebarMenuItem'
import { useState, useEffect } from 'react'
import { useLocation } from 'react-router-dom'
import SideBarUserIndicator from './SidebarUserIndicator'

const sidebarData = {
    navMain: [
        {
            title: 'Dashboard',
            icon: Gauge,
            url: '/'
        },
        {
            title: 'Interactable Chart',
            icon: ChartLine,
            url: '/chart-demo'
        }
    ],
    navBottoms: [
        {
            title: 'Settings',
            icon: Cog,
            url: '/settings'
        },
        {
            title: 'Get Help',
            icon: CircleQuestionMark,
            url: '/help'
        }
    ]
}

function SideBar({className, ...props} : {className?: string, props?: React.ReactNode}) {
    const [currentSelection, setCurrentSelection] = useState('');
    const location = useLocation();
    
    const isItemSelected = (itemUrl: string) => {
        return location.pathname === itemUrl;
    };

    return(
    <div id='sidebar-container' className={`w-full h-full flex flex-col justify-between ${className || ''}`}>
        <div id='header-area' className='flex flex-col gap-5'>
            <div className='h-20 p-5'>
                <h1>
                    Here is icon
                </h1>
            </div>
            <div id='nav-main' className='flex flex-col gap-2'>
                {sidebarData.navMain.map((item) => (
                    <SidebarMenuItem item={item} key={item.title} isSelected={isItemSelected(item.url)}/>
                ))}
            </div>
        </div>
        <div id='bottom-area' className='flex flex-col gap-5'>
            <div id='bottom-navigate' className='flex flex-col gap-0'>
                {sidebarData.navBottoms.map((item) => (
                    <SidebarMenuItem item={item} key={item.title} isSelected={isItemSelected(item.url)}/>
                ))}
            </div>
            <SideBarUserIndicator />
        </div>
    </div>
    );
}

export default SideBar;