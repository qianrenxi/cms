package org.qianrenxi.cms.service;

import java.util.Arrays;

import org.qianrenxi.cms.entity.Article;
import org.qianrenxi.cms.entity.Article.Status;
import org.qianrenxi.cms.repository.ArticleRepository;
import org.qianrenxi.common.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class ArticleService extends BaseCrudService<ArticleRepository, Article, Long> {
	
	
	public void publish(Long[] ids){
		updateStatus(Status.PUBLISHED, Arrays.asList(ids));
	}
	
	public void disPublish(Long[] ids){
		updateStatus(Status.DRAFT, Arrays.asList(ids));
	}
	
	public void updateStatus(Status status,Iterable<Long> ids){
		repository.updateStatus(status, ids);
	}
}
