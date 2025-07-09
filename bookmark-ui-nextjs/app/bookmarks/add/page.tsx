'use client'
import { saveBookmark } from '@/services/api/fetchBookmarks';
import React, { useState } from 'react'


const page = () => {

    const [title, setTitle] = useState("");
    const [url,setUrl] = useState("");
    const [message, setMessage] = useState<String|null>(null);

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) =>{
        e.preventDefault();
        // 서버를 호출 할 부분

        // 유효성 검사
        if(!url){
            alert("url을 입력해 주세요");
            return;
        }

        const payload = {
            title,
            url
        }

        try {
            saveBookmark(payload)
                .then(reponse =>{
                    console.log("Save Bookmark reponse", reponse);
                    setTitle("");
                    setUrl("");
                    setMessage("새로운 Bookmark를 저장하였습니다")
                })
                .catch(error =>{
                    setMessage(error.message || "새로운 Bookmark를 저장에 실패하였습니다")
                })
        } catch (error) {
            // Promise가 reject된 경우
            setMessage("새로운 Bookmark를 저장에 실패하였습니다")
        }
    }

    return (
        <div>
           {message && <div className='alert alert-primary' role='alert'>{message}</div>}
           <form onSubmit={e => handleSubmit(e)}>
            <legend>새로운 Bookmark 등록</legend>
            <div className='mb-3'>
                <label htmlFor='title' className='form-label'>제목</label>
                <input type='text' id='title' className='form-control' placeholder='Title' value={title} onChange={e=>setTitle(e.target.value)} />
            </div>
            <div className='mb-3'>
                <label htmlFor='url' className='form-label'>링크</label>
                <input type='text' id="url" className='form-control' placeholder='Link' value={url} onChange={e => setUrl(e.target.value)}/>
            </div>
            <div className='d-grid gap-2 col-6 mx-auto'>
                <button type='submit' className='btn btn-primary'>Submit</button>
            </div>

           </form>
        </div>
    )
}

export default page
