package xyz.lemone.apihub.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lemone.apihub.runner.SqlRunner;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    private SqlRunner sqlRunner;

    @Autowired
    private DataSource dataSource;

    @GetMapping("test")
    public Object demo() {

        HashMap<String, Object> param = new HashMap<>(1);
        param.put("loginUser.username", "177");
        String configSql =
                "${ " +
                        "if(param('loginUser.username')=='admin'){ " +
                            "return 'select * from merchants_driver' " +
                        "} else {" +
                            "return 'select * from merchants_driver where driver_tel = :loginUser.username' " +
                        "}" +
                "}";

        String sql = sqlRunner.parseSql(configSql, param);
        System.out.println(sql);
        NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource);
        List<Map<String, Object>> maps = jdbc.queryForList(sql, param);
        return maps;


    }


}
