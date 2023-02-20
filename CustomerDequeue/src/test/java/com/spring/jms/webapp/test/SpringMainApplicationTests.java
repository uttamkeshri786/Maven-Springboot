package com.spring.jms.webapp.test;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.spring.jms.webapp.config.HttpClientConfig;
import com.spring.jms.webapp.config.RestTemplateConfig;
import com.spring.jms.webapp.model.Customer;
import com.spring.jms.webapp.service.CustomerService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

@SuppressWarnings({ "unused", "deprecation" })
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestTemplateConfig.class, HttpClientConfig.class })
public class SpringMainApplicationTests {
    
    @Autowired
    private TestRestTemplate testRestTemplate1;
    
    @Autowired
    private AsyncRestTemplate testRestTemplate;
    
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    private CustomerService customerService;
    
    @Test
    public void getCustomer() {
      final String url = "http://localhost:8080/customer";
      String result = restTemplate.getForObject(url, String.class);
      Assert.assertEquals(true, result.indexOf("Uttam") > 0);
    }
    
    @Test
    public void testAddCustomer() {

        Customer customer = new Customer(261, "Bharti", "Services", "test@customer.com", LocalDate.of(2022, 9, 12));
        customerService.add(customer);
        assertThat(customerService.findAll()).contains(customer);
    }
    
    @Test
    public void testDeleteCustomer() {
    
        Customer customer = customerService.find(101).get();
        customerService.remove(101);
        List<Customer> all = customerService.findAll();
        //assertThat(all).doesNotContain(customer);
    }
    
    @Test
    public void testIndexPage() {
        @SuppressWarnings("unchecked")
        ResponseEntity<String> response = (ResponseEntity<String>) testRestTemplate.getForEntity("/", String.class);
        //ResponseEntity<String> response = testRestTemplate("/", String.class);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        Assert.assertEquals("Uttam", response.getBody());
        //Assert.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        //Assert.assertThat(response.getBody()).contains("Uttam");
    }

    private ResponseEntity<String> testRestTemplate(String string, Class<String> class1) {
        // TODO Auto-generated method stub
        return null;
    }

    //@Test-method: findAll()
    private List<Customer> assertThat(List<Customer> findAll) {
        // TODO Auto-generated method stub
        Customer customer = new Customer();
        List<Customer> all = customerService.findAll();
        if( all == null) {
            //assertThat(all).doesNotContain(customer);
        }
        return null;
    }
    
        public static void main(String[] args) throws Exception {

        // 1. Configure FreeMarker
        
        /*
         * You should do this ONLY ONCE, when your application starts, then reuse the
         * same Configuration object elsewhere.
         */
        Configuration cfg = new Configuration();

        /* Where do we load the templates from: */
        cfg.setClassForTemplateLoading(SpringMainApplicationTests.class, "templates");

        /* Some other recommended settings: */
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // 2. Proccess template(s)

        // You will do this for several times in typical applications.
        // 2.1. Prepare the template input:

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("firstname", "Uttam");
        input.put("surname", "Keshri");
        input.put("email", "uttam.keshri@bcssarl.com");
        input.put("dob", "2022/09/09");
        
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(101, "Uttam", "Keshri", "uttam.keshri@bcssarl.com", LocalDate.of(1998, 05, 15)));
        customers.add(new Customer(201, "Nilesh", "Pawar", "nilesh@microsoft.com", LocalDate.of(1993, 10, 28)));
        customers.add(new Customer(201, "Shweta", "Pawar", "shweta@gmail.com", LocalDate.of(1996, 8, 21)));
        customers.add(new Customer(201, "Kishan", "Panchal", "kishan@abc.xyz", LocalDate.of(1989, 3, 16)));
       
        /* 2.2. Get the template */
        Template template = cfg.getTemplate("index.ftl");
 
        /* 2.3. Generate the output */
        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        /* For the sake of example, also write output into a file: */
        Writer fileWriter = new FileWriter(new File("FreeMarker.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }
        
        }   
}