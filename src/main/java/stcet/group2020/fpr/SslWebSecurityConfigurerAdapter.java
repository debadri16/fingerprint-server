// package stcet.group2020.fpr;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration(proxyBeanMethods = false)
// public class SslWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         // Customize the application security
//         http.requiresChannel().anyRequest().requiresSecure();
//     }

// }