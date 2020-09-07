package playingVideo;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class EmulatorAutoLaunch {
	
	@BeforeSuite
	public void startEmulator() throws IOException,InterruptedException{
	CommandLine cmd = new CommandLine("C:\\Android\\sdk\\emulator\\emulator.exe");
	cmd.addArgument("-avd");
	cmd.addArgument("PIXELXL29");
	
	DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
	DefaultExecutor executor = new DefaultExecutor();
	executor.setExitValue(1);

		executor.execute(cmd, handler);
		Thread.sleep(120000);
		
	} 

	@AfterSuite
	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM qemu-system-x86_64.exe");
			System.out.println("Emulator Killed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public static void server() throws IOException, InterruptedException {
		EmulatorAutoLaunch Emulator = new EmulatorAutoLaunch();
		Emulator.startEmulator();

		Emulator.stopServer();
	}
}
	

