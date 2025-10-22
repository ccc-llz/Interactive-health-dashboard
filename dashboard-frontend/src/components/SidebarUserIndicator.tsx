import React, { forwardRef, useEffect, useState } from "react";
import { Avatar, AvatarIcon, Button, Card } from "@heroui/react"
import defaultAvartar from "../assets/豹豹Idle.svg";
import { userAPI } from "../service/api";
import { API_CONFIG } from "../config/api";

type Props = {
  currentAvatar?: string;
  children?: React.ReactNode;
  className?: string;
  username?: string;
  userAvatarUrl?: string;
} & React.HTMLAttributes<HTMLDivElement>;

const SideBarUserIndicator = forwardRef<HTMLDivElement, Props>(({ currentAvatar, children, className, username, userAvatarUrl: propAvatarUrl, ...props }, ref) => {
  const [userId, setUserId] = useState<number>(0);
  const [userAvatarUrl, setUserAvatarUrl] = useState<string | null>(propAvatarUrl || null);

  useEffect(() => {
    let mounted = true;
    const fetchAvatar = async () => {
      try {
        const responseData = await userAPI.getAvatar();
        if (!mounted) return;
        if (responseData && responseData.id) {
          setUserId(responseData.id);
          if (responseData.avatarUrl) {
            setUserAvatarUrl(`${API_CONFIG.BASE_URL}${responseData.avatarUrl}`);
          }
        }
      } catch (err) {
        console.error("Failed to load avatar", err);
      }
    };

    if (!propAvatarUrl) {
      fetchAvatar();
    }

    return () => {
      mounted = false;
    };
  }, [propAvatarUrl]);

  return (
    <div role="button" tabIndex={0} ref={ref} className="w-full h-max-[40px] p-2 flex gap-3 items-end rounded-lg hover:shadow-xs hover:bg-white dark:hover:bg-violet-900/50 transition-all active:bg-white active:inset-shadow-sm" {...props}>
      <div className='aspect-square'>
        <Avatar classNames={{
          base: 'bg-linear-to-b from-sky-700 dark:from-violet-400 to-sky-50 dark:to-violet-700',
          icon: 'text-white/80'
        }}
          icon={<AvatarIcon />} src={userAvatarUrl || defaultAvartar} />
      </div>
      <div className="w-full h-full flex-col">
        <h2 className="text-black/70 dark:text-white/70 text-sm">
          Hello,
        </h2>
        <h1 className="text-medium">
          {username || 'Jane Doe'}
        </h1>
      </div>
    </div>
  );
});

export default SideBarUserIndicator;