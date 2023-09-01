import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'

function ArticleList({ articles }) {
  console.log('articleList:', articles);

  return (
    <>
      <div>
        <button type="button" className="btn btn-primary">글 등록</button>
      </div>
      <br />
      <div className="row-6">
        {
         articles && articles.map((data, idx) => { 
         return(
          <>
         <div className="card">
              <div className="card-header">
              </div>
              <div className="card-body">
                  <h5 className="card-title"></h5>
                  <p className="card-text"></p>
                  <a className="btn btn-primary">보러가기</a>
              </div>
          </div>
          <br />
          </>
          )
        })}
      </div>
    </>
  )
}

export default ArticleList