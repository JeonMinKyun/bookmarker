import React from 'react'
import { BookmarksResponse } from '../types/bookmark'
import Bookmark from './Bookmark';

//Prop타입의 정의
interface BookmarksProps{
    bookmakrs: BookmarksResponse;
}


const Bookmarks = ({bookmakrs}: BookmarksProps) => {
  return (
    <>
      {bookmakrs.data.map((bookmark)=>(
        <Bookmark key={bookmark.id} bookmark={bookmark} />
      ))}
    </>
  )
}

export default Bookmarks
