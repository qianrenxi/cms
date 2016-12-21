package org.qianrenxi.cms.web.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.qianrenxi.cms.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ArticleApiTests {
	@Autowired
    private WebApplicationContext context;
	@Value("${local.server.port}")
    private int port;
	
	@Autowired
	private ArticleApiController articleApi;

	
	private MockMvc mockMvc;
	private RestTemplate restTemplate = new TestRestTemplate();
	
	//@Before
	public void setupMockMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	//@Test
	public void testList() {
		Page<Article> page = restTemplate.getForObject("http://localhost:"+port+"/api/article/list", PageImpl.class);
		assertNotNull(page);
		assertEquals(0, page.getTotalElements());
	}
}
