# mrVoIP
<img src="imgREADME/labMusimatica.png" alt="drawing" width="150" height="100"/>
<img src="imgREADME/dinfUnisa.png" alt="drawing" width="500" height="150"/>
<img src="imgREADME/logo_unisa.png" alt="drawing" width="150" height="150"/>
## **Author: Eugenio De Simone**

App developed for research purposes, to analyze the security of the VoIP protocol on Android 10.
To carry out the analysis of VoIP traffic this application has been developed, once started it remains running on the user's device thanks to a BroadcastReceiver that takes care of restarting the **Service** through **ForegroundService**. The application detects if there are VoIP calls in progress and if so, connects the device to a Wi-Fi network (**attacker's hotspot**). The attacker uses [**Wireshark**](https://www.wireshark.org) software for VoIP traffic analysis.


| ![Attacco](https://user-images.githubusercontent.com/32223916/134635165-9e487dd2-6313-4fc4-8dd3-3f3df8627c72.png) |
|:--:|
| **Attack Scenario** |


# Tools and technologies
* **IDE:** Android Studio
* **Android Version:** Android 10 API 29
* **Language:** Java
* **Network Analyzer:** Wireshark

# [mrVoIP Doc](https://edesimone12.github.io/mrVoIP/)
