import Bookmarks from '@/components/Bookmarks';
import Pagenation from '@/components/Pagenation';
import SearchForm from '@/components/SearchForm';
import { fetchBookmarks } from '@/services/api/fetchBookmarks';
import React from 'react';

const Home = async ({ searchParams }: { searchParams: Promise<{ page?: string, query?: string }> }) => {
  const { page, query } = await searchParams; // ✅ 반드시 await 필요
  const pageNumber = page ? parseInt(page, 10) : 1;
  const queryString = query ? String(query) : "";

  const bookmarks = await fetchBookmarks(pageNumber, queryString); // 서버사이드 데이터 패칭

  return (
    <div>
      <h2>Welcome to Bookmark</h2>
      <SearchForm />
      <Pagenation bookmarks={bookmarks} query={query}/>
      <ul>
        {/* {bookmarks.data.map((bookmark) => (
          <li key={bookmark.id}>{bookmark.title}</li> 
        ))} */}
        <Bookmarks bookmarks={bookmarks}/>
      </ul>
    </div>
  );
};


export default Home;