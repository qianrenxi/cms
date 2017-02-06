package org.qianrenxi.cms.service;

import java.util.List;

import org.qianrenxi.cms.entity.Category;
import org.qianrenxi.cms.repository.CategoryRepository;
import org.qianrenxi.common.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseCrudService<CategoryRepository, Category, Long> {

	public List<Category> getRoots() {
		return repository.findByParentIsNull();
	}

	public List<Category> getChildren(Long parentId) {
		if (null != parentId) {
			return repository.findByParentId(parentId);
		} else {
			return getRoots();
		}
	}
}
