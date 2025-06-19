import { Bookmark, BookmarksResponse } from '@/app/types/bookmark'
import axios from 'axios'
import React from 'react'


const getApiUrl = () =>{
  // 서버사이드 URL(Docker로 배포된 서버사이드 호출시 사용)
  const serverApiUrl = process.env.SERVER_SIDE_API_BASE_URL;

  // 클라이언트 사이드 URL(브라우저에서 호출할 공개용 API 주소, 도메인등)
  const clientApiUrl = process.env.NEXT_PUBLIC_CLIENT_SIDE_API_BASE_URL;

  if(typeof window === 'undefined'){
    console.log("🌐 서버 사이드 실행 - 사용 URL:", serverApiUrl);
    return serverApiUrl || clientApiUrl;
  }
  console.log("🌍 클라이언트 사이드 실행 - 사용 URL:", clientApiUrl);

  return clientApiUrl;
}

// const API_BASE_URL = 'http://localhost:8080';
export const fetchBookmarks = async(page:number, query?:string):Promise<BookmarksResponse> => {
  let apiUrl = getApiUrl();
  // const resp = await axios.get<BookmarksResponse>(`${API_BASE_URL}/api/bookmarks?page=${page}&query=${query}`)
  const resp = await axios.get<BookmarksResponse>(`${apiUrl}/api/bookmarks?page=${page}&query=${query}`)
    return resp.data;
}

export const saveBookmark = async(bookmark:{title:string, url:string}) =>{
  let apiUrl = getApiUrl();
  try {
    // const resp = await axios.post(`${API_BASE_URL}/api/bookmarks`, bookmark);
    const resp = await axios.post(`${apiUrl}/api/bookmarks`, bookmark);
    // const resp = await axios.post(`${apiUrl}/api/bookmarks`, bookmark, {
    //   headers: {
    //     'Content-Type': 'application/json',
    //   },
    // });
    return resp.data;
  } catch (error) {
    // 에러가 발생한 경우 message 전달 하여 화면에 출력
    console.error("Error saving bookmark :" , error)
    throw new Error("북마크 저장에 실패하였습니다. 다시 시도해 주세요")
  }
}
