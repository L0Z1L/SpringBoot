//package com.demo;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@ComponentScan(basePackages = {"com.UserRepository"})
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//class DemoApplicationTests {
////    @Autowired(required = false)
////    private JdbcTemplate jdbcTemplate;
////    @Test
////    void contextLoads() {
////        String sql = "select * from user_action limit "+10;
////        List<User> totle =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
////        System.out.println(totle.get(1));
////    }
////    @Test
////    void contextLoads() {
////        String pythonScriptPath = "src\\main\\resources\\static\\Bar.py"; // 替换为你的Python脚本路径
////        String[] cmd = {"python", pythonScriptPath};
////
////        try {
////            //创建进程
////            ProcessBuilder pb = new ProcessBuilder(cmd);
////            Process process = pb.start();//启动进程
////
////            // 读取脚本输出 返回进程输出
////            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
////            String line;
////            StringBuilder output = new StringBuilder();
////            while ((line = reader.readLine()) != null) {
////                output.append(line).append("\n");
////
////            }
////
////            int exitCode = process.waitFor();
////            if (exitCode == 0) {
////                // 脚本成功执行
////                System.out.println( "Python script executed successfully.\n" + output.toString());
////            } else {
////                // 脚本执行失败
////                System.out.println( "Python script execution failed with exit code " + exitCode);
////            }
////        } catch (IOException | InterruptedException e) {
////            e.printStackTrace();
////            System.out.println("An error occurred while executing the Python script: " + e.getMessage());
////        }
////    }
//
//}
//
