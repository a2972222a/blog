package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Article;
import service.AddArticleService;
import service.QueryArticleService;
import serviceImpl.AddArticleServiceImpl;
import serviceImpl.QueryArticleServiceImpl;

/**
 * @author 秦晓阳
 * 类说明
 */
public class Test {
	public static void main(String[] args) throws SQLException {
		System.out.println("````````````````````````start");
		String title = "test1";
		String content = "lasdjflskjfs";
		String tag = "test";
		//传入文章对象
		Article a = new Article();
		a.setTitle(title);
		a.setContent(content);
		a.setTag(tag);
		AddArticleService aasi = new AddArticleServiceImpl();
		try {
			aasi.addArticle(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("`````````````````middle````````````````````");
		
		//查询文章
		List<Article> list = new ArrayList<Article>();
		QueryArticleService qas = new QueryArticleServiceImpl();
		list = qas.queryArticle("t");
		System.out.println(list);
		for (Article article : list) {
			System.out.println("*****************************");
			System.out.println(article.getTitle());
			System.out.println(article.getTag());
			System.out.println(article.getContent());
		}
		System.out.println("````````````````````````````end");
	}
}
