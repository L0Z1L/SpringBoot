package com.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class PythonController {

    @GetMapping("/run-python")
    public String runPythonScript() {
        String pythonScriptPath = "src\\main\\resources\\static\\Bar.py"; // 替换为你的Python脚本路径
        String[] cmd = {"python", pythonScriptPath};

        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            Process process = pb.start();

            // 读取脚本输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                // 脚本成功执行
                return "Python script executed successfully.\n" + output.toString();
            } else {
                // 脚本执行失败
                return "Python script execution failed with exit code " + exitCode;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "An error occurred while executing the Python script: " + e.getMessage();
        }
    }
}