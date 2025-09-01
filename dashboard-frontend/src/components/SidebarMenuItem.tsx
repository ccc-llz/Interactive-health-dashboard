import { Button } from '@heroui/react'
import { useNavigate } from 'react-router-dom';

const SidebarMenuItem = ({ item, isSelected, ...props }: {
    item: {
        title: string,
        icon: any,
        url?: string
    },
    isSelected?: boolean,
    props?: React.ReactNode;
}) => {
    const navigate = useNavigate();
    const navigateTo = (url?: string) => {
        if (url) navigate(url);
    }

    return (
        <button className={`flex items-center justify-start m-0 p-2 gap-2 rounded-xl text-sm outline-white/30 outline-0 
            ${!isSelected ? 'hover:backdrop-saturate-125 hover:bg-white/90 hover:shadow-xs text-black active:bg-white/90 active:backdrop-saturate-200 active:inset-shadow-sm active:shadow-none'
                : 'bg-gradient-to-b from-white/20 to-blue-900/20 backdrop-saturate-700 backdrop-brightness-80 text-white text-shadow-md outline-1 hover:backdrop-brightness-85 shadow-md'} 
                 transition-all duration-100`}
            onClick={() => navigateTo(item.url)}
            color='primary'
        >
            <item.icon className={`${isSelected ? 'drop-shadow-sm/30' : ''} transition-all duration-100`} />
            <span>{item.title}</span>
        </button>
    );
}


export default SidebarMenuItem;