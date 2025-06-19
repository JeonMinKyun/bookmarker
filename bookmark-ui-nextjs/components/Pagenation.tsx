import { BookmarksResponse } from '@/app/types/bookmark'
import Link from 'next/link';
import React from 'react'

interface PagenationProps{
    bookmarks : BookmarksResponse,
    query?: string
}

const Pagenation = ({bookmarks, query}: PagenationProps) => {

    const path = "/bookmarks";
    const queryParams = (query === undefined || query ==="")? {} :{query:query}
    // const firstPage = {pathname:path, query:{page:1, ...queryParams}}
    const previousPage = {pathname:path, query:{page:bookmarks.currentPage-1, ...queryParams}}
    // const nextPage = {pathname:path, query:{page:bookmarks.currentPage+1, ...queryParams}}
    const lastPage = {pathname:path, query:{page:bookmarks.totalPage, ...queryParams}}

  return (
      <div>
            <nav aria-label="Page navigation">
                <ul style={{ display: 'flex', justifyContent: 'space-between', padding: 0, listStyle: 'none' }} className="pagination">
                    <li className={"page-item" + (bookmarks.hasPrevious? "": "disabled")}>
                        <Link className="page-link" href={previousPage}>Previous</Link>
                    </li>
                    <li className={"page-item" + (bookmarks.hasNext? "": "disabled")}>
                        <Link className="page-link" href={lastPage}>Next</Link>
                    </li>
                </ul>
            </nav>
        </div>
  )
}

export default Pagenation