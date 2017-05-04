package application;

import java.io.File;

import com.android.apksigner.ApkSignerTool;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

public class MainController {
	@FXML
	Label tvTitle;

	@FXML
	TextField tfApkPath;

	@FXML
	TextField tfKeyStorePath;

	@FXML
	PasswordField pfKeyStorePwd;

	@FXML
	PasswordField pfAliasPwd;

	@FXML
	ChoiceBox<String> cbAlias;

	@FXML
	TextArea taResult;

	/**
	 * 选择apk文件
	 *
	 * @param event
	 */
	@FXML
	private void onChooseApk(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter apkFilter = new FileChooser.ExtensionFilter("安卓应用程序 (*.apk)", "*.apk");
		fileChooser.getExtensionFilters().add(apkFilter);
		File file = fileChooser.showOpenDialog(Main.getPrimaryStage());
		if (file != null) {
			System.out.println(file);
			tfApkPath.setText(file.getAbsolutePath());
		}
	}

	/**
	 * 选择秘钥签名文件
	 *
	 * @param event
	 */
	@FXML
	private void onChooseKeyStore(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter jksFilter = new FileChooser.ExtensionFilter("安卓签名文件 (*.jks)", "*.jks");
		FileChooser.ExtensionFilter keystoreFilter = new FileChooser.ExtensionFilter("安卓签名文件 (*.keystore)",
				"*.keystore");
		fileChooser.getExtensionFilters().add(jksFilter);
		fileChooser.getExtensionFilters().add(keystoreFilter);
		File file = fileChooser.showOpenDialog(Main.getPrimaryStage());
		if (file != null) {
			System.out.println(file);
			tfKeyStorePath.setText(file.getAbsolutePath());
		}
	}

	/**
	 * 输入签名秘钥密码
	 *
	 * @param event
	 */
	@FXML
	private void onKeyStorePwdEnd(KeyEvent event) {
		String msg = String.format("onKeyStorePwdEnd %s\n", pfKeyStorePwd.getText());
		System.err.printf(msg);
	}

	/**
	 * 开始签名
	 *
	 * @param event
	 */
	@FXML
	private void onGotoSignature(ActionEvent event) {
		String msg = String.format("onGotoSignature %s\n", event);
		System.err.printf(msg);
		taResult.clear();
		try {
			String[] cmd = { "--ks=" + tfKeyStorePath.getText(),
//					"--ks-key-alias=appABook",
					"--ks-pass=pass:" + pfKeyStorePwd.getText(),
					"--key-pass=pass:" + pfAliasPwd.getText(),
					"--in=" + tfApkPath.getText(),
					"--out=asset\\sign_" + System.currentTimeMillis() + ".apk" };
			ApkSignerTool.sign(cmd);

			taResult.setText("签名成功");
		} catch (Exception e) {
			taResult.setText(e.getMessage());
		}
	}

}
