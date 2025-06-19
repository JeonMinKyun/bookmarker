import type { Bookmark } from '@/app/types/bookmark'
import Link from 'next/link';
import React from 'react'

interface BookmarkProps{
    bookmark :Bookmark;
}

const Bookmark = ({bookmark}:BookmarkProps) => {
  return (
    <>
        <li>
            <Link href={bookmark.url}>{bookmark.title}</Link>
        </li>
    </>
  )
}

export default Bookmark