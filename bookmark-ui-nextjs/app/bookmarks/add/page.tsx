'use client'
import { saveBookmark } from '@/services/api/fetchBookmarks';
import React, { useState } from 'react'

const AddBookmark = () => {

  const [title, setTitle] = useState("");
  const [url, setUrl] = useState("");
  const [message, setMessage] = useState<string|null>(null) ;

  const handleSubmit = (e:React.FormEvent<HTMLFormElement>) =>{
    e.preventDefault();
    if(!url){
      alert("URL을 입력해 주세요");
      return
    }
    const payload = {
      title,
      url
    }

    try {
      saveBookmark(payload)
        .then(response =>{
          console.log("Save Bookmark response", response);
          setTitle("");
          setUrl("");
          setMessage("새로운 Bookmark를 저장하였습니다");
        })
        .catch(error =>{
          setMessage(error.message||"새로운 Bookmark 저장에 실패하였습니다");
        })
    } catch (error) {
      console.log(error)
      setMessage("새로운 Bookmark 저장에 실패하였습니다");
    }
  }

  return (
      <div>
        {message && <div className="alert alert-primary" role="alert">{message}</div>}
        <form onSubmit={e => handleSubmit(e)}>
          <fieldset>
              <legend>새로운 Bookmark 등록</legend>
          <div className="mb-3 mt-3">
            <label htmlFor="title" className="form-label">제목:</label>
            <input type="text" className="form-control" id="title" placeholder="Enter title"  value={title} onChange={e => setTitle(e.target.value)}/>
          </div>
          <div className="mb-3">
            <label htmlFor="url" className="form-label">URL:</label>
            <input type="text" className="form-control" id="url" placeholder="Enter url" value={url} onChange={e => setUrl(e.target.value)}/>
          </div>
         
          <button type="submit" className="btn btn-primary">Submit</button>

          </fieldset>
        </form>
      </div>
  )
}

export default AddBookmark