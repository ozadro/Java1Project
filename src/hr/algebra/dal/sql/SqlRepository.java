/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Article;
import hr.algebra.model.Journalists;
import hr.algebra.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Korisnik
 */
public class SqlRepository implements Repository {
    
    private static final String ID = "IDUser";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String ADMIN = "Admin";

    private static final String ID_ARTICLE = "IDArticle";
    private static final String TITLE = "Title";
    private static final String LINK = "Link";
    private static final String DESCRIPTION = "Description";
    private static final String PICTURE_PATH = "PicturePath";
    private static final String PUBLISHED_DATE = "PublishedDate";
    
    private static final String ID_JOURNALIST = "IDJournalist";
    private static final String FIRSTNAME = "FirstName";
    private static final String LASTNAME = "LastName";
    private static final String AGE = "Age";
    private static final String EMAIL = "Email";

    private static final String CREATE_ARTICLE = "{ CALL createArticle (?,?,?,?,?,?) }";
    private static final String UPDATE_ARTICLE = "{ CALL updateArticle (?,?,?,?,?,?) }";
    private static final String DELETE_ARTICLE = "{ CALL deleteArticle (?) }";
    private static final String SELECT_ARTICLE = "{ CALL selectArticle (?) }";
    private static final String SELECT_ARTICLES = "{ CALL selectArticles }";
     private static final String DELETE_ARTICLES = "{ CALL deleteAllArticles }";
  
    private static final String SELECT_USERS = "{ CALL selectUsers }";
    private static final String CREATE_USER = "{ CALL CreateUser (?,?) }";
    
     private static final String CREATE_JOURNALIST = "{ CALL createJournalist (?,?,?,?,?,?) }";
    private static final String UPDATE_JOURNALIST = "{ CALL updateJournalist (?,?,?,?,?,?) }";
    private static final String DELETE_JOURNALIST = "{ CALL deleteJournalist (?) }";
    private static final String SELECT_JOURNALIST = "{ CALL selectJournalist (?) }";
    private static final String SELECT_JOURNALISTS = "{ CALL selectJournalists }";
     private static final String DELETE_JOURNALISTS = "{ CALL deleteAllJournalists }";
    
    @Override
    public List<User> selectUsers()  {
        List<User> users = new ArrayList<>();

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USERS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(
                        new User(
                                rs.getInt(ID),
                                rs.getString(USERNAME),
                                rs.getString(PASSWORD),
                                rs.getBoolean(ADMIN))
                );
            }
        } catch (SQLException ex) { 
            Logger.getLogger(SqlRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    @Override
    public void createUser(User user) {
          DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_USER)) {

            stmt.setString("@" + USERNAME, user.getUsername());
            stmt.setString("@" + PASSWORD, user.getPassword());
            stmt.executeUpdate();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      @Override
    public int createArticle(Article article) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ARTICLE)) {

            stmt.setString("@" + TITLE, article.getTitle());
            stmt.setString("@" + LINK, article.getLink());
            stmt.setString("@" + DESCRIPTION, article.getDescription());
            stmt.setString("@" + PICTURE_PATH, article.getPicturePath());
            stmt.setString("@" + PUBLISHED_DATE, article.getPublishedDate().format(Article.DATE_FORMATTER));
            stmt.registerOutParameter("@" + ID_ARTICLE, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt("@" + ID_ARTICLE);
        }
    }

    @Override
    public void createArticles(List<Article> articles) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ARTICLE)) {

            for (Article article : articles) {
                stmt.setString("@" + TITLE, article.getTitle());
                stmt.setString("@" + LINK, article.getLink());
                stmt.setString("@" + DESCRIPTION, article.getDescription());
                stmt.setString("@" + PICTURE_PATH, article.getPicturePath());
                stmt.setString("@" + PUBLISHED_DATE, article.getPublishedDate().format(Article.DATE_FORMATTER));
                stmt.registerOutParameter("@" + ID_ARTICLE, Types.INTEGER);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void updateArticle(int id, Article data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_ARTICLE)) {

            stmt.setString("@" + TITLE, data.getTitle());
            stmt.setString("@" + LINK, data.getLink());
            stmt.setString("@" + DESCRIPTION, data.getDescription());
            stmt.setString("@" + PICTURE_PATH, data.getPicturePath());
            stmt.setString("@" + PUBLISHED_DATE, data.getPublishedDate().format(Article.DATE_FORMATTER));
            stmt.setInt("@" + ID_ARTICLE, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteArticle(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ARTICLE)) {

            stmt.setInt("@" + ID_ARTICLE, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Article> selectArticle(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ARTICLE)) {

            stmt.setInt("@" + ID_ARTICLE, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Article(
                            rs.getInt(ID_ARTICLE),
                            rs.getString(TITLE),
                            rs.getString(LINK),
                            rs.getString(DESCRIPTION),
                            rs.getString(PICTURE_PATH),
                            LocalDateTime.parse(rs.getString(PUBLISHED_DATE), Article.DATE_FORMATTER)));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Article> selectArticles() throws Exception {
        List<Article> articles = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ARTICLES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                articles.add(new Article(
                        rs.getInt(ID_ARTICLE),
                        rs.getString(TITLE),
                        rs.getString(LINK),
                        rs.getString(DESCRIPTION),
                        rs.getString(PICTURE_PATH),
                        LocalDateTime.parse(rs.getString(PUBLISHED_DATE), Article.DATE_FORMATTER)));
            }
        }
        return articles;
    }

    @Override
    public void deleteAllArticles() {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ARTICLES);)
                {
                    stmt.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(SqlRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int createJournalist(Journalists journalist) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_JOURNALIST)) {

            stmt.setString("@" + FIRSTNAME, journalist.getFirstName());
            stmt.setString("@" + LASTNAME, journalist.getLastName());
            stmt.setString("@" + AGE, journalist.getAge());
            stmt.setString("@" + EMAIL, journalist.getEmail());
            stmt.setString("@" + PICTURE_PATH, journalist.getPicturePath());
            stmt.registerOutParameter("@" + ID_JOURNALIST, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt("@" + ID_JOURNALIST);
        }
    }

    @Override
    public void createJournalists(List<Journalists> journalists) throws Exception {
           DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_JOURNALIST)) {

            for (Journalists journalist : journalists) {
            stmt.setString("@" + FIRSTNAME, journalist.getFirstName());
            stmt.setString("@" + LASTNAME, journalist.getLastName());
            stmt.setString("@" + AGE, journalist.getAge());
            stmt.setString("@" + EMAIL, journalist.getEmail());
            stmt.setString("@" + PICTURE_PATH, journalist.getPicturePath());
            stmt.registerOutParameter("@" + ID_JOURNALIST, Types.INTEGER);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void updateJournalist(int id, Journalists data) throws Exception {
      DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_JOURNALIST)) {

            stmt.setString("@" + FIRSTNAME, data.getFirstName());
            stmt.setString("@" + LASTNAME, data.getLastName());
            stmt.setString("@" + AGE, data.getAge());
            stmt.setString("@" + EMAIL, data.getEmail());
            stmt.setString("@" + PICTURE_PATH, data.getPicturePath());
            stmt.setInt("@" + ID_JOURNALIST, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteJournalist(int id) throws Exception {
          DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_JOURNALIST)) {

            stmt.setInt("@" + ID_JOURNALIST, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Journalists> selectJournalist(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_JOURNALIST)) {

            stmt.setInt("@" + ID_JOURNALIST , id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Journalists(
                            rs.getInt(ID_JOURNALIST),
                            rs.getString(FIRSTNAME),
                            rs.getString(LASTNAME),
                            rs.getString(AGE),
                            rs.getString(EMAIL),
                            rs.getString(PICTURE_PATH)));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Journalists> selectJournalists() throws Exception {
        List<Journalists> journalists = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_JOURNALISTS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                journalists.add(new Journalists(
                        rs.getInt(ID_JOURNALIST),
                            rs.getString(FIRSTNAME),
                            rs.getString(LASTNAME),
                            rs.getString(AGE),
                            rs.getString(EMAIL),
                            rs.getString(PICTURE_PATH)));
            }
        }
        return journalists;
    }

    @Override
    public void deleteAllJournalists() {
          DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_JOURNALISTS);)
                {
                    stmt.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(SqlRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     
}
