 /*
*information 
*/
var L_FullScreenWarn1_Text = "当前的安全设置不允许自动切换到全屏模式。 " 
var L_FullScreenWarn2_Text = "您可以用 Ctrl-Alt-Pause 将远程桌面会话切换到全屏模式 " 
var L_FullScreenTitle_Text = "远程桌面 Web 连接 " 
var L_ErrMsg_Text  = "连接到远程计算机时的错误: " 
var L_PlatformCheck_ErrorMessage = "远程桌面 Web 连接 ActiveX 控件只能在 32 位版本的Internet Explorer中运行。 " 
/*
*error messages 
*/
var L_Undefined_ErrorMessage = "请您下载 远程桌面WEB连接 ActiveX 控件。";
var L_RemoteDesktopCaption_ErrorMessage ="远程桌面连接 " 
var L_DisconnectedCaption_ErrorMessage ="远程桌面连接已被中断 " 
var L_ErrConnectCallFailed_ErrorMessage ="客户端连接到远程计算机时出现错误。请检查系统内存，然后重新连接。 " 
var L_DisconnectRemoteByServer_ErrorMessage = "远程计算机已结束连接。" 
var L_LowMemory_ErrorMessage = "本地计算机内存不足。请关闭一些程序，然后再连接到远程计算机。 " 
var L_SecurityErr_ErrorMessage = "由于安全错误，客户端无法连接到远程计算机。请确认您已登录到网络，然后重新连接。 " 
var L_BadServerName_ErrorMessage = "找不到指定的远程计算机。请确认您键入的计算机名和 IP 地址是否正确，然后重新连接。 " 
var L_ConnectFailedProtocol_ErrorMessage = "由于一个协议错误，客户端无法连接到远程计算机。请重新廉洁到远程计算机。如果客户端依旧无法连接，请跟网络管理员联系。 " 
var L_CannotLoopBackConnect_ErrorMessage = "客户端无法连接，您无法从同一台计算机的控制台会话连接到控制台。 " 
var L_NetworkErr_ErrorMessage = "由于网络错误，连接被结束。请重新连接到远程计算机。 " 
var L_InternalErr_ErrorMessage = "出现了一个内部错误。 " 
var L_NotResponding_ErrorMessage = "客户端无法连接到远程计算机。远程连接没有启用，或者计算机太忙，无法接受新连接。也有可能网络问题阻碍了连接。请重新连接。如果问题继续出现，请跟系统管理员联系。 " 
var L_VersionMismatch_ErrorMessage = "客户端和服务器版本不相符。请升级客户端软件，然后重新连接。 " 
var L_EncryptionError_ErrorMessage = "由于数据加密的错误，这个会话将结束。请重新连接到远程计算机。 " 
var L_ProtocolErr_ErrorMessage = "由于协议错误，这个会话将被中断。请重新连接到远程计算机。 " 
var L_IllegalServerName_ErrorMessage = "指定的计算机名含有无效字符。请确认计算机名，重试一次。 " 
var L_ConnectionTimeout_ErrorMessage = "远程连接已超时。请重新连接到远程计算机。 " 
var L_DisconnectIdleTimeout_ErrorMessage = "由于达到了空闲超时限度，远程会话被结束。这个限度是服务器管理员或网络策略设置的。 " 
var L_DisconnectLogonTimeout_ErrorMessage = "由于达到了总登录时间限度，远程会话被结束。这个限度是服务器管理员或网络策略设置的。 " 
var L_ProtocolErrWITHCODE_ErrorMessage= "由于内部协议错误，客户端已中断连接: " 
var L_LicensingTimeout_ErrorMessage = "客户端试图连接时，出现了一个授权错误(授权超时)。请重新跟远程计算机连接。 " 
var L_LicensingNegotFailed_ErrorMessage = "由于授权协议中的一个错误，远程计算机中断了会话。请重新跟远程计算机连接；或者跟服务器管理员联系。 " 
var L_DisconnectRemoteByServerTool_ErrorMessage = "跟远程计算机的远程会话被一个管理工具结束。可能是您的管理员中断了您的连接。 " 
var L_LogoffRemoteByServer_ErrorMessage = "由于会话在远程计算机上被注销，远程会话被中断。您的系统管理员或另一个用户结束了您的连接。 " 
var L_DisconnectByOtherConnection_ErrorMessage = "由于另一个用户连接到了会话，远程会话被中断。 " 
var L_ConnectionBroken_ErrorMessage= "跟远程计算机的连接被打断。请重新连接到远程计算机。 " 
var L_ServerOutOfMemory_ErrorMessage = "由于远程计算机内存不足，连接被中断。 " 
var L_LicenseInternal_ErrorMessage = "由于远程计算机的授权协议中有一个内部错误，远程会话被中断。 " 
var L_NoLicenseServer_ErrorMessage = "由于没有终端服务器许可证服务器可以提供许可证，远程会话被中断。请跟服务器管理员联系。 " 
var L_NoLicense_ErrorMessage = "由于这台计算机没有终端服务器客户端访问许可证，远程会话被中断。请跟服务器管理员联系。 " 
var L_LicenseBadClientMsg_ErrorMessage = "由于远程计算机从这台计算机收到一个无效的授权消息，远程会话被中断。 " 
var L_LicenseHwidDoesntMatch_ErrorMessage = "由于这台计算机上储存的终端服务器客户端访问许可证已被修改，远程会话被中断。 " 
var L_BadClientLicense_ErrorMessage = "由于这台计算机上储存的终端服务器客户端访问许可证的格式无效，远程会话被中断。 " 
var L_LicenseCantFinishProtocol_ErrorMessage = "由于授权协议中有网络问题，远程会话被中断。请重新跟远程计算机连接。 " 
var L_LicenseClientEndedProtocol_ErrorMessage = "由于客户端过早地结束了授权协议，远程会话被中断。 " 
var L_LicenseBadClientEncryption_ErrorMessage = "由于授权消息的加密不正确，远程会话被中断。 " 
var L_CantUpgradeLicense_ErrorMessage = "由于无法升级或重续本地计算机的客户端访问许可证，远程会话被中断。请跟服务器管理员联系。 " 
var L_LicenseNoRemoteConnections_ErrorMessage = "由于远程计算机没有授权接受远程连接，远程会话被中断。请跟服务器管理员联系。 " 
var L_DecompressionFailed_ErrorMessage = "由于客户端的解压缩操作失败，远程会话被中断。请重新连接到远程计算机。 " 
var L_ServerDeniedConnection_ErrorMessage = "客户端无法建立跟远程计算机的连接。导致这个错误的可能的原因是: 1) 远程计算机上的远程连接可能没有启用。2) 已超出远程计算机上的连接最大数。3) 建立连接时出现了一个网络错误。 " 
var L_ControlLoadFailed_ErrorMessage= "远程桌面 Web 连接 ActiveX 控制无法安装。在没有一个安装后运行正常的控制版本的情况下，无法进行连接。请与服务器的管理员联系。 " 
var L_InvalidServerName_ErrorMessage = "指定了一个无效服务器。 "

function ReturnToConnectPage(){
	var rannum=parseInt(Math.random()*(12345) + 654321);
    window.location.href="remote.html?random="+rannum; 
}

function MsRdpClient_OnDisconnected(extendedDiscReason){ 
      errMsgText   =   L_DisconnectRemoteByServer_ErrorMessage;
      if (extendedDiscReason!=0){  //Use   the   extended   disconnect   code 
           switch(extendedDiscReason){
            case   0:errMsgText     =   "";
            case   1: errMsgText     =   L_DisconnectRemoteByServerTool_ErrorMessage ;break ;
            case   2: errMsgText     =   L_LogoffRemoteByServer_ErrorMessage ;break ;
            case   3: errMsgText     =   L_DisconnectIdleTimeout_ErrorMessage ;break ;
            case   4: errMsgText     =   L_DisconnectLogonTimeout_ErrorMessage ;break ;
            case   5: errMsgText     =   L_DisconnectByOtherConnection_ErrorMessage ;break ;
            case   6: errMsgText     =   L_ServerOutOfMemory_ErrorMessage ;break ;
            case   7: errMsgText     =   L_ServerDeniedConnection_ErrorMessage ;break ;
            case   256:errMsgText     =   L_LicenseInternal_ErrorMessage ;break ;
            case   257:errMsgText     =   L_NoLicenseServer_ErrorMessage ;break ;
            case   258:errMsgText     =   L_NoLicense_ErrorMessage ;break ;
            case   259:errMsgText     =   L_LicenseBadClientMsg_ErrorMessage ;break ;
            case   260:errMsgText     =   L_LicenseHwidDoesntMatch_ErrorMessage ;break ;
            case   261:errMsgText     =   L_BadClientLicense_ErrorMessage ;break ;
            case   262:errMsgText     =   L_LicenseCantFinishProtocol_ErrorMessage ;break ;
            case   263:errMsgText     =   L_LicenseClientEndedProtocol_ErrorMessage ;break ;
            case   264:errMsgText     =   L_LicenseBadClientEncryption_ErrorMessage ;break ;
            case   265:errMsgText     =   L_CantUpgradeLicense_ErrorMessage ;break ;
            case   266:errMsgText     =   L_LicenseNoRemoteConnections_ErrorMessage ;break ;
            case   516  : errMsgText     =   L_NotResponding_ErrorMessage ;break ;
            case   518  : errMsgText     =   L_LowMemory_ErrorMessage ;break ;
            case   520  : errMsgText     =   L_BadServerName_ErrorMessage ;break ;
            case   772  : errMsgText     =   L_NetworkErr_ErrorMessage ;break ;
            case   774  : errMsgText     =   L_LowMemory_ErrorMessage ;break ;
            case   776  : errMsgText     =   L_BadServerName_ErrorMessage ;break ;
            case   1028  : errMsgText   =   L_NetworkErr_ErrorMessage ;break ;
            case   1030  : errMsgText   =   L_SecurityErr_ErrorMessage ;break ;
            case   1032  : errMsgText   =   L_IllegalServerName_ErrorMessage ;break ;
            case   1286  : errMsgText   =   L_EncryptionError_ErrorMessage ;break ;
            case   1288 :errMsgText   =   L_BadServerName_ErrorMessage ;break ;
            case   1540 : errMsgText   =   L_BadServerName_ErrorMessage ;break ;
            case   1542 : errMsgText   =   L_SecurityErr_ErrorMessage ;break ;
            case   1544 :errMsgText   =   L_LowMemory_ErrorMessage ;break ;
            case   1796 :errMsgText   =   L_NotResponding_ErrorMessage ;break ;
            case   1798 :errMsgText   =   L_SecurityErr_ErrorMessage ;break ;
            case   1800 : errMsgText   =   L_CannotLoopBackConnect_ErrorMessage ;break ;
            case   2052 : errMsgText   =   L_BadServerName_ErrorMessage ;break ;
            case   2056 : errMsgText   =   L_LicensingNegotFailed_ErrorMessage ;break ;
            case   2310 : errMsgText   =   L_SecurityErr_ErrorMessage ;break ;
            case   2566 : errMsgText   =   L_SecurityErr_ErrorMessage ;break ;
            case   2822 : errMsgText   =   L_EncryptionError_ErrorMessage ;break ;
            case   3078 :errMsgText   =   L_EncryptionError_ErrorMessage ;break ;
            case   3080 : errMsgText   =   L_DecompressionFailed_ErrorMessage ;break ;
            case   3334 :errMsgText   =   L_ProtocolErr_ErrorMessage ;break ;
            case   10500 : errMsgText   =   L_ProtocolErr_ErrorMessage ;break ;
            case   "undefined" :errMsgText = L_Undefined_ErrorMessage ;break ;
            default:errMsgText   =   L_ErrMsg_Text + L_Undefined_ErrorMessage ;
           }
           
    }else{
   		ReturnToConnectPage();
      }
      return errMsgText;
}