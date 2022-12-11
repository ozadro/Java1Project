/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.model.Article;
import hr.algebra.model.User;
import hr.algebra.model.Journalists;
import java.util.List;
import java.util.Optional;




/**
 *
 * @author dnlbe
 */
public interface Repository {
   
  public List<User> selectUsers();
  public void createUser(User user);
  
    int createArticle(Article article) throws Exception;
    void createArticles(List<Article> articles) throws Exception;    
    void updateArticle(int id, Article data) throws Exception;
    void deleteArticle(int id) throws Exception;
    Optional<Article> selectArticle(int id) throws Exception;
    List<Article> selectArticles() throws Exception;
     void deleteAllArticles();
     
    int createJournalist(Journalists article) throws Exception;
    void createJournalists(List<Journalists> articles) throws Exception;    
    void updateJournalist(int id, Journalists data) throws Exception;
    void deleteJournalist(int id) throws Exception;
    Optional<Journalists> selectJournalist(int id) throws Exception;
    List<Journalists> selectJournalists() throws Exception;
    void deleteAllJournalists();
     
     
   
}
