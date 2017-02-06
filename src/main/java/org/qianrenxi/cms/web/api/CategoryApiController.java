package org.qianrenxi.cms.web.api;

import java.util.ArrayList;
import java.util.List;

import org.qianrenxi.cms.entity.Category;
import org.qianrenxi.cms.service.CategoryService;
import org.qianrenxi.cms.web.api.ao.CategoryAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController {

	@Autowired
	protected CategoryService categoryService;

	@RequestMapping(value = "tree", method = RequestMethod.GET)
	public List<Category> tree() {
		List<Category> categories = categoryService.getRoots();
		return categories;
	}

	@RequestMapping(value = "children", method = RequestMethod.GET)
	public List<CategoryAO> children(@RequestParam(name = "parentId", required = false) Long parentId) {
		List<Category> categories = categoryService.getChildren(parentId);
		List<CategoryAO> categoryAOs = new ArrayList<>();
		for (Category category : categories) {
			CategoryAO categoryAO = new CategoryAO();
			BeanUtils.copyProperties(category, categoryAO);
			categoryAOs.add(categoryAO);
		}
		return categoryAOs;
	}

	@RequestMapping("{id}")
	public Category getCategoryById(@PathVariable("id") Long id) {
		return categoryService.findOne(id);
	}

	@RequestMapping(value = "save", method = { RequestMethod.POST, RequestMethod.PUT })
	public Category save(@RequestBody() Category category) {
		return categoryService.save(category);
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		categoryService.delete(id);
	}
}
