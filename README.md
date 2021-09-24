# mrVoIP
![LogoDinfUnisa]()
## **Author: Eugenio De Simone**
![dinfUnisa](https://user-images.githubusercontent.com/32223916/134699115-f2071204-f971-4d85-9c88-f7c7e849b78a.png)
![labMusimatica](https://user-images.githubusercontent.com/32223916/134699222-6987a180-b062-4e7c-91aa-b5cf3ea9169d.png)
![logo_unisa](https://user-images.githubusercontent.com/32223916/134699283-38d14da1-2073-4037-8ab3-d4a5f3c86d59.png)


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
