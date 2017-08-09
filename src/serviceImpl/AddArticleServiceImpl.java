package serviceImpl;

import java.sql.SQLException;

import dao.ArticleDAO;
import daoImpl.ArticleDAOImpl;
import entity.Article;
import service.AddArticleService;

/**
 * @author 秦晓阳
 * 实现添加文章的业务
 */
public class AddArticleServiceImpl implements AddArticleService {

	@Override
	public void addArticle(Article a) throws SQLException {
		ArticleDAO ad = new ArticleDAOImpl();
		ad.add(a);
	}

}
