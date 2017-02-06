package org.qianrenxi.cms.repository;

import org.qianrenxi.cms.entity.Article;
import org.qianrenxi.cms.entity.Article.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
	
	@Modifying(clearAutomatically = true)
	@Query("update Article art set art.status = :status where art.id in :ids")
	@Transactional
	public void updateStatus(@Param("status") Status status, @Param("ids") Iterable<Long> ids);
}
