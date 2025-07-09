import { fetchBookmarks } from '@/services/api/fetchBookmarks';
import React from 'react'
import Bookmarks from '../components/Bookmarks';
import Pagination from '../components/Pagination';
import SearchForm from '../components/SearchForm';


// 서버를 요청하는 컴포넌트

// Next.js 15에서는 searchParam가 동기 객체가 아니라 Promise 형태로 되기 때문에 Pomise로 처리해야 한다
const page = async ({searchParams}: {searchParams :Promise<{ page ?: string, query ?: string}>}) => {
  const { page, query } = await searchParams;
  const pageNumber = page ? parseInt(page, 10):1;
  const queryString = query ? String(query) : "";

  const bookmarks = await fetchBookmarks(pageNumber, queryString);
  return (
    <div>
      <h2>Welcome to Bookmarks</h2>
      <SearchForm />
      <Pagination bookmarks={bookmarks} query={query} />

      <ul>
        <Bookmarks bookmakrs={bookmarks}/>
      </ul>
    </div>
  )
}

export default page
