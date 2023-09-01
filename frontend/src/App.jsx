import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom'; // <--- Routes를 import
import ArticleNew from './pages/ArticleNew';
import ArticleList from './pages/ArticleList';
import Header from './layout/Header';
import { useState, useEffect } from 'react';
import React from 'react';

function App() {
  const [articleData, setArticle] = useState(null);

  const articleListData = async () => {
    await fetch('/api/articles')
      .then(function(response) {
        return response.json();
      })
      .then(articles => {
        console.log('articles data :', articles);
        setArticle(articles);
      });
  };

  useEffect(() => {
    articleListData();
  }, []);

  return (
    <BrowserRouter>
      <Header />
      <div className="container">
        <Routes>
          <Route path='/article-new' element={<ArticleNew />} />
          <Route path='/articles' element={<ArticleList articles={articleData} />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;