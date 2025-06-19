import { BookmarksResponse } from '@/app/types/bookmark'
import React from 'react'
import Bookmark from './Bookmark';

interface BookmarksProps {
  bookmarks: BookmarksResponse;
}

const Bookmarks = ({ bookmarks } : BookmarksProps) => {
  return (
    <>
      {bookmarks.data.map((bookmark) => (
        // <li key={bookmark.id}>{bookmark.title}</li>
        <Bookmark key={bookmark.id} bookmark={bookmark}/>
      ))}
    </>
  );
};

export default Bookmarks