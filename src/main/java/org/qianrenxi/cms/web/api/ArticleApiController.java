package org.qianrenxi.cms.web.api;

import org.qianrenxi.cms.entity.Article;
import org.qianrenxi.cms.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class ArticleApiController {
	@Autowired
	protected ArticleService articleService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Page<Article> articlePageList(Article article, Pageable pageable) {
		Page<Article> articles = articleService.findAll(article, pageable);
		return articles;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Article getArticleById(@PathVariable Long id) {
		return articleService.findOne(id);
	}

	@RequestMapping(value = "save", method = { RequestMethod.POST, RequestMethod.PUT })
	public Article save(@RequestBody Article article) {
		return articleService.save(article);
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long id) {
		articleService.delete(id);
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody Long[] ids) {
		articleService.delete(ids);
	}

	@RequestMapping(value = "publish", method = RequestMethod.PUT)
	public void publish(@RequestBody Long[] ids) {
		articleService.publish(ids);
	}
	
	@RequestMapping(value = "disPublish", method = RequestMethod.PUT)
	public void disPublish(@RequestBody Long[] ids) {
		articleService.disPublish(ids);
	}
}
