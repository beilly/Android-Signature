package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    /**
     * 选择apk文件
     * @param event
     */
    @FXML
    private void onChooseApk(ActionEvent event){
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
     * @param event
     */
    @FXML
    private void onChooseKeyStore(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter jksFilter = new FileChooser.ExtensionFilter("安卓签名文件 (*.jks)", "*.jks");
        FileChooser.ExtensionFilter keystoreFilter = new FileChooser.ExtensionFilter("安卓签名文件 (*.keystore)", "*.keystore");
        fileChooser.getExtensionFilters().add(jksFilter);
        fileChooser.getExtensionFilters().add(keystoreFilter);
        File file = fileChooser.showOpenDialog(Main.getPrimaryStage());
        if (file != null) {
            System.out.println(file);
            tfKeyStorePath.setText(file.getAbsolutePath());
		}
    }

    /**
     * 选择秘钥签名文件
     * @param event
     */
    @FXML
    private void onGotoSignature(ActionEvent event){
        System.err.printf("onGotoSignature %s\n", event);
    }


}
