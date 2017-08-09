package serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleDAO;
import daoImpl.ArticleDAOImpl;
import entity.Article;
import service.QueryArticleService;

/**
 * @author ÇØÏþÑô
 * ÀàËµÃ÷
 */
public class QueryArticleServiceImpl implements QueryArticleService {

	@Override
	public List<Article> queryArticle(String str) throws SQLException {
		List<Article> list = new ArrayList<Article>();
		ArticleDAO ad = new ArticleDAOImpl();
		list = ad.query(str);
		return list;
	}

}
