package it.ipzs.cieid;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Middleware extends Library {
	//Middleware INSTANCE = (Middleware) Native.loadLibrary("cie-pkcs11", Middleware.class);
	Middleware INSTANCE = (Middleware) Native.loadLibrary("/home/piero/Desktop/IPZS/cie-middleware-linux/Debug/libcie-pkcs11.so", Middleware.class);
	
	interface ProgressCallBack extends Callback {
        void invoke(int progress, String message);
    }
	
	interface CompletedCallBack extends Callback {
        void invoke(String pan, String name, String ef_seriale);
    }
	
	interface SignCompletedCallBack extends Callback {
		void invoke(int retValue);
	}

	public int AbilitaCIE(String szPAN, String szPIN, int[] attempts, ProgressCallBack progressCallBack, CompletedCallBack completedCallBack);
	public int VerificaCIEAbilitata(String szPAN);
	public int firmaConCIE(String inFilePath, String type, String pin, String pan, int page, float x, float y, float w, float h, String imagePathFile, String outFilePath, ProgressCallBack progressCallBack, SignCompletedCallBack completedCallBack);
	//public int verificaConCIE(String inFilePath, verfifyInfos_t vInfos);
	public int DisabilitaCIE(String szPAN);
	public int CambioPIN(String  currentPIN, String nuovoPIN, int[] attempts, ProgressCallBack progressCallBack);
	public int SbloccoPIN(String puk, String nuovoPIN, int[] attempts, ProgressCallBack progressCallBack);

}

