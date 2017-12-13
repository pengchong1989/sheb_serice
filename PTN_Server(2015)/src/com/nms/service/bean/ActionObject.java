﻿package com.nms.service.bean;

import java.util.ArrayList;
import java.util.List;

import com.nms.drive.service.bean.ARPObject;
import com.nms.drive.service.bean.AclObject;
import com.nms.drive.service.bean.AlarmObject;
import com.nms.drive.service.bean.AlarmShieldObject;
import com.nms.drive.service.bean.BfdObject;
import com.nms.drive.service.bean.BlackWhiteMacObject;
import com.nms.drive.service.bean.CccObject;
import com.nms.drive.service.bean.ClockObject;
import com.nms.drive.service.bean.E1Object;
import com.nms.drive.service.bean.ELanObject;
import com.nms.drive.service.bean.ELineObject;
import com.nms.drive.service.bean.ETHLinkOAMObject;
import com.nms.drive.service.bean.ETHOAM;
import com.nms.drive.service.bean.ETHOAMAllObject;
import com.nms.drive.service.bean.ETreeObject;
import com.nms.drive.service.bean.EXPToPHBObject;
import com.nms.drive.service.bean.EthLoopObject;
import com.nms.drive.service.bean.EthServiceObject;
import com.nms.drive.service.bean.GlobalObject;
import com.nms.drive.service.bean.GroupSpreadObject;
import com.nms.drive.service.bean.IGMPSNOOPINGObject;
import com.nms.drive.service.bean.L2CPinfoObject;
import com.nms.drive.service.bean.LoopProRotateObject;
import com.nms.drive.service.bean.MacLearningObject;
import com.nms.drive.service.bean.MacManageObject;
import com.nms.drive.service.bean.ManagementObject;
import com.nms.drive.service.bean.MsPwObject;
import com.nms.drive.service.bean.NEObject;
import com.nms.drive.service.bean.OSPFinfoWhObeject;
import com.nms.drive.service.bean.PHBToEXPObject;
import com.nms.drive.service.bean.PerformanceObject;
import com.nms.drive.service.bean.PmValueLimiteObject;
import com.nms.drive.service.bean.Port2LayerObject;
import com.nms.drive.service.bean.PortLAGObject;
import com.nms.drive.service.bean.PortObject;
import com.nms.drive.service.bean.PortSeniorConfig;
import com.nms.drive.service.bean.ProtectRorateObject;
import com.nms.drive.service.bean.PwObject;
import com.nms.drive.service.bean.PwQueueAndBufferManage;
import com.nms.drive.service.bean.QinQObject;
import com.nms.drive.service.bean.ResponsePan;
import com.nms.drive.service.bean.RoundProtectionObject;
import com.nms.drive.service.bean.SecondMacStudyObject;
import com.nms.drive.service.bean.SingleObject;
import com.nms.drive.service.bean.SinglePan;
import com.nms.drive.service.bean.SmartFanObject;
import com.nms.drive.service.bean.SoftwareUpdate;
import com.nms.drive.service.bean.StaticUnicastObject;
import com.nms.drive.service.bean.TMCOAMBugControlObject;
import com.nms.drive.service.bean.TMCTunnelProtectObject;
import com.nms.drive.service.bean.TMPOAMBugControlObject;
import com.nms.drive.service.bean.TMSOAMBugControlObject;
import com.nms.drive.service.bean.TMSOAMObject;
import com.nms.drive.service.bean.TdmLoopObject;
import com.nms.drive.service.bean.TimeSyncObject;
import com.nms.drive.service.bean.TimeSynchronizeObject;
import com.nms.drive.service.bean.TunnelObject;
import com.nms.drive.service.bean.TunnelProtection;
import com.nms.drive.service.bean.UpgradeManageObject;
import com.nms.drive.service.bean.V35PortObject;
import com.nms.drive.service.bean.status.OamStatusObject;
import com.nms.drive.service.bean.status.PingOrderControllerObject;
import com.nms.drive.service.bean.status.SiteStatusObject;


/**
 * 武汉驱动事件对象
 * @author Administrator
 *
 */
public class ActionObject {

	private int actionId = 0;//操作ID
	private String status = "";//设备返回值
	private NEObject neObject = new NEObject();
	private int servicetType = 0;//类型 tunnel pw等
	private String type = "";// 类型 tunnel pw等
	private long performanceBeginDataTime;// （起始时间）年，年，月，日，时，分，秒
	private int performanceCount = 0;// 历史性能个数
	private int performanceBeginCount = 0;// 历史性能起始数
	private int performanceType = 0;// 性能数据类型（00，20，21，30）
	private List<TunnelObject> tunnelObjectList = new ArrayList<TunnelObject>();
	private List<PwObject> pwObjectList = new ArrayList<PwObject>();
	private List<PortObject> protObjectList = new ArrayList<PortObject>();
	private List<ELanObject> elanObejctList = new ArrayList<ELanObject>();
	private List<ETreeObject> etreeObjectList = new ArrayList<ETreeObject>();
	private List<ELineObject> elineObjectList = new ArrayList<ELineObject>();
	private List<TunnelProtection> LSPProtectionList = new ArrayList<TunnelProtection>();
	private ETHOAM ethOAM = new ETHOAM();
	private E1Object e1Object = new E1Object();
	private AlarmObject alarmObject = new AlarmObject();
	private PerformanceObject performanceObject = new PerformanceObject();
	private TMPOAMBugControlObject tmpOAMBugControlObject = new TMPOAMBugControlObject();
	private PwQueueAndBufferManage pwQueueAndBufferManage = new PwQueueAndBufferManage();
	private TMCOAMBugControlObject tmcOAMBugControlObject = new TMCOAMBugControlObject();
	private List<PortLAGObject> portLAGList = new ArrayList<PortLAGObject>();
	private List<TMCTunnelProtectObject> tmcTunnelProectList = new ArrayList<TMCTunnelProtectObject>();
	private TimeSynchronizeObject timeSynchronizeObject = new TimeSynchronizeObject();
	private TMSOAMObject tmsOamObject = new TMSOAMObject();
	private List<PHBToEXPObject> phbToEXPObject = new ArrayList<PHBToEXPObject>();
	private TMSOAMBugControlObject tmsOAMBugControlObject = new TMSOAMBugControlObject();
	private List<PortSeniorConfig> seniorPortConfigObjectlist = new ArrayList<PortSeniorConfig>();
	private List<EXPToPHBObject> expToPHBObject = new ArrayList<EXPToPHBObject>();
	private ClockObject clockObject = new ClockObject();

	private List<ETHLinkOAMObject> ethLinkOAMObject = new ArrayList<ETHLinkOAMObject>();
	private List<RoundProtectionObject> roundProtectionObject = new ArrayList<RoundProtectionObject>();
	private List<IGMPSNOOPINGObject> igmpsnooping = new ArrayList<IGMPSNOOPINGObject>();
	private GlobalObject globalObject = new GlobalObject();
	private List<GroupSpreadObject> groupSpreadObject = new ArrayList<GroupSpreadObject>();
	private SingleObject singleObject = new SingleObject();
	private List<StaticUnicastObject> staticUnicast = new ArrayList<StaticUnicastObject>();
	private ManagementObject managementObject = new ManagementObject();
	private SinglePan singlePan = new SinglePan();
	private ResponsePan responsePan = new ResponsePan();
	private SoftwareUpdate softwareUpdate = new SoftwareUpdate();
	private byte[] bs ;
	private List<TMSOAMObject> tmsoamObjects = new ArrayList<TMSOAMObject>();
	//ethOAM
	private ETHOAMAllObject ethoamAllObject = new ETHOAMAllObject();
	
	private List<MsPwObject> msPwObjects = new ArrayList<MsPwObject>();
	private SiteStatusObject siteStatusObject = new SiteStatusObject();
	private PmValueLimiteObject pmValueLimiteObject = new PmValueLimiteObject();
	private List<QinQObject> qinQObjects = new ArrayList<QinQObject>();
	private List<MacManageObject> macManageObjectList = new ArrayList<MacManageObject>();
	private List<MacLearningObject> macLearningObjectList = new ArrayList<MacLearningObject>();
	private OamStatusObject oamStatusObject = new OamStatusObject();
	private PingOrderControllerObject pingOrderControllerObject = new PingOrderControllerObject();
	private EthLoopObject ethLoopObject = new EthLoopObject();
	private List<BlackWhiteMacObject>  blackWhiteMacObjectList = new ArrayList<BlackWhiteMacObject>();
	private AclObject AclObject = new AclObject();
	private List<UpgradeManageObject> upgradeManageObjects = new ArrayList<UpgradeManageObject>();
	private V35PortObject v35PortObject = new V35PortObject();
	private LoopProRotateObject loopProRotateObject = new LoopProRotateObject();
	private List<SmartFanObject> smartFanObjectList = new ArrayList<SmartFanObject>();
	private List<NEObject> neObjects = new ArrayList<NEObject>();
	private TdmLoopObject tdmLoopObject = new TdmLoopObject();
	private EthServiceObject EthServiceObject = new EthServiceObject();
	private AlarmShieldObject alarmShieldObject = new AlarmShieldObject();//告警屏蔽对象
	private L2CPinfoObject L2CPinfoObject = new L2CPinfoObject();
	private List<SecondMacStudyObject> secondMacStudyObjectList = new ArrayList<SecondMacStudyObject>();
	private List<Port2LayerObject> port2LayerObjectList = new ArrayList<Port2LayerObject>();
	private ProtectRorateObject protectRorateObject = new ProtectRorateObject();
	private TimeSyncObject timesyncobject = new TimeSyncObject();	
	private List<CccObject> cccObjectList = new ArrayList<CccObject>();	
    private List<BfdObject> bfdObjectList = new ArrayList<BfdObject>();
    private List<ARPObject> arpObjectList = new ArrayList<ARPObject>();
	private List<OSPFinfoWhObeject> ospFinfoWhObejects = new ArrayList<OSPFinfoWhObeject>();
	
	
	public List<OSPFinfoWhObeject> getOspFinfoWhObejects() {
		return ospFinfoWhObejects;
	}
	public void setOspFinfoWhObejects(List<OSPFinfoWhObeject> ospFinfoWhObejects) {
		this.ospFinfoWhObejects = ospFinfoWhObejects;
	}
	public List<ARPObject> getArpObjectList() {
		return arpObjectList;
	}
	public void setArpObjectList(List<ARPObject> arpObjectList) {
		this.arpObjectList = arpObjectList;
	}
	public List<BfdObject> getBfdObjectList() {
		return bfdObjectList;
	}
	public void setBfdObjectList(List<BfdObject> BfdObjectList) {
		this.bfdObjectList = BfdObjectList;
	}	
	public List<CccObject> getCccObjectList() {
		return cccObjectList;
	}
	public void setCccObjectList(List<CccObject> CccObjectList) {
		this.cccObjectList = CccObjectList;
	}	
	public TimeSyncObject getTimesyncobject() {
		return timesyncobject;
	}
	public void setTimesyncobject(TimeSyncObject timesyncobject) {
		this.timesyncobject = timesyncobject;
	}
	public List<Port2LayerObject> getPort2LayerObjectList() {
		return port2LayerObjectList;
	}
	public void setPort2LayerObjectList(List<Port2LayerObject> port2LayerObjectList) {
		this.port2LayerObjectList = port2LayerObjectList;
	}
	public List<NEObject> getNeObjects() {
		return neObjects;
	}
	public void setNeObjects(List<NEObject> neObjects) {
		this.neObjects = neObjects;
	}
	public TdmLoopObject getTdmLoopObject() {
		return tdmLoopObject;
	}
	public void setTdmLoopObject(TdmLoopObject tdmLoopObject) {
		this.tdmLoopObject = tdmLoopObject;
	}
	public LoopProRotateObject getLoopProRotateObject() {
		return loopProRotateObject;
	}
	public void setLoopProRotateObject(LoopProRotateObject loopProRotateObject) {
		this.loopProRotateObject = loopProRotateObject;
	}
	public V35PortObject getV35PortObject() {
		return v35PortObject;
	}
	public void setV35PortObject(V35PortObject v35PortObject) {
		this.v35PortObject = v35PortObject;
	}
	public List<UpgradeManageObject> getUpgradeManageObjects() {
		return upgradeManageObjects;
	}
	public void setUpgradeManageObjects(List<UpgradeManageObject> upgradeManageObjects) {
		this.upgradeManageObjects = upgradeManageObjects;
	}
	public List<MacLearningObject> getMacLearningObjectList() {
		return macLearningObjectList;
	}
	public void setMacLearningObjectList(
			List<MacLearningObject> macLearningObjectList) {
		this.macLearningObjectList = macLearningObjectList;
	}
	public List<MacManageObject> getMacManageObjectList() {
		return macManageObjectList;
	}
	public void setMacManageObjectList(List<MacManageObject> macManageObjectList) {
		this.macManageObjectList = macManageObjectList;
	}
	public SiteStatusObject getSiteStatusObject() {
		return siteStatusObject;
	}
	public void setSiteStatusObject(SiteStatusObject siteStatusObject) {
		this.siteStatusObject = siteStatusObject;
	}
	public List<MsPwObject> getMsPwObjects() {
		return msPwObjects;
	}
	public void setMsPwObjects(List<MsPwObject> msPwObjects) {
		this.msPwObjects = msPwObjects;
	}
	public ProtectRorateObject getProtectRorateObject() {
		return protectRorateObject;
	}
	public void setProtectRorateObject(ProtectRorateObject protectRorateObject) {
		this.protectRorateObject = protectRorateObject;
	}
	public SoftwareUpdate getSoftwareUpdate() {
		return softwareUpdate;
	}

	public void setSoftwareUpdate(SoftwareUpdate softwareUpdate) {
		this.softwareUpdate = softwareUpdate;
	}

	public ManagementObject getManagementObject() {
		return managementObject;
	}

	public void setManagementObject(ManagementObject managementObject) {
		this.managementObject = managementObject;
	}

	public List<PortSeniorConfig> getSeniorPortConfigObjectlist() {
		return seniorPortConfigObjectlist;
	}

	public void setSeniorPortConfigObjectlist(List<PortSeniorConfig> seniorPortConfigObjectlist) {
		this.seniorPortConfigObjectlist = seniorPortConfigObjectlist;
	}

	public TMSOAMBugControlObject getTmsOAMBugControlObject() {
		return tmsOAMBugControlObject;
	}

	public void setTmsOAMBugControlObject(TMSOAMBugControlObject tmsOAMBugControlObject) {
		this.tmsOAMBugControlObject = tmsOAMBugControlObject;
	}

	public TMCOAMBugControlObject getTmcOAMBugControlObject() {
		return tmcOAMBugControlObject;
	}

	public void setTmcOAMBugControlObject(TMCOAMBugControlObject tmcOAMBugControlObject) {
		this.tmcOAMBugControlObject = tmcOAMBugControlObject;
	}

	public List<PortLAGObject> getPortLAGList() {
		return portLAGList;
	}

	public void setPortLAGList(List<PortLAGObject> portLAGList) {
		this.portLAGList = portLAGList;
	}

	public PwQueueAndBufferManage getPwQueueAndBufferManage() {
		return pwQueueAndBufferManage;
	}

	public void setPwQueueAndBufferManage(PwQueueAndBufferManage pwQueueAndBufferManage) {
		this.pwQueueAndBufferManage = pwQueueAndBufferManage;
	}

	public int getPerformanceCount() {
		return performanceCount;
	}

	public void setPerformanceCount(int performanceCount) {
		this.performanceCount = performanceCount;
	}

	public int getPerformanceBeginCount() {
		return performanceBeginCount;
	}

	public void setPerformanceBeginCount(int performanceBeginCount) {
		this.performanceBeginCount = performanceBeginCount;
	}

	public int getPerformanceType() {
		return performanceType;
	}

	public void setPerformanceType(int performanceType) {
		this.performanceType = performanceType;
	}

	public AlarmObject getAlarmObject() {
		return alarmObject;
	}

	public void setAlarmObject(AlarmObject alarmObject) {
		this.alarmObject = alarmObject;
	}

	public PerformanceObject getPerformanceObject() {
		return performanceObject;
	}

	public void setPerformanceObject(PerformanceObject performanceObject) {
		this.performanceObject = performanceObject;
	}

	public List<TunnelProtection> getLSPProtectionList() {
		return LSPProtectionList;
	}

	public void setLSPProtectionList(List<TunnelProtection> lSPProtectionList) {
		LSPProtectionList = lSPProtectionList;
	}

	public E1Object getE1Object() {
		return e1Object;
	}

	public void setE1Object(E1Object object) {
		e1Object = object;
	}

	public ETHOAM getEthOAM() {
		return ethOAM;
	}

	public void setEthOAM(ETHOAM ethOAM) {
		this.ethOAM = ethOAM;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public NEObject getNeObject() {
		return neObject;
	}

	public void setNeObject(NEObject neObject) {
		this.neObject = neObject;
	}

	public List<TunnelObject> getTunnelObjectList() {
		return tunnelObjectList;
	}

	public void setTunnelObjectList(List<TunnelObject> tunnelObjectList) {
		this.tunnelObjectList = tunnelObjectList;
	}

	public List<PwObject> getPwObjectList() {
		return pwObjectList;
	}

	public void setPwObjectList(List<PwObject> pwObjectList) {
		this.pwObjectList = pwObjectList;
	}

	public List<PortObject> getProtObjectList() {
		return protObjectList;
	}

	public void setProtObjectList(List<PortObject> protObjectList) {
		this.protObjectList = protObjectList;
	}

	public List<ELanObject> getElanObejctList() {
		return elanObejctList;
	}

	public void setElanObejctList(List<ELanObject> elanObejctList) {
		this.elanObejctList = elanObejctList;
	}

	public List<ETreeObject> getEtreeObjectList() {
		return etreeObjectList;
	}

	public void setEtreeObjectList(List<ETreeObject> etreeObjectList) {
		this.etreeObjectList = etreeObjectList;
	}

	public List<ELineObject> getElineObjectList() {
		return elineObjectList;
	}

	public void setElineObjectList(List<ELineObject> elineObjectList) {
		this.elineObjectList = elineObjectList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TMPOAMBugControlObject getTmpOAMBugControlObject() {
		return tmpOAMBugControlObject;
	}

	public void setTmpOAMBugControlObject(TMPOAMBugControlObject tmpOAMBugControlObject) {
		this.tmpOAMBugControlObject = tmpOAMBugControlObject;
	}

	public List<TMCTunnelProtectObject> getTmcTunnelProectList() {
		return tmcTunnelProectList;
	}

	public void setTmcTunnelProectList(List<TMCTunnelProtectObject> tmcTunnelProectList) {
		this.tmcTunnelProectList = tmcTunnelProectList;
	}

	public TimeSynchronizeObject getTimeSynchronizeObject() {
		return timeSynchronizeObject;
	}

	public void setTimeSynchronizeObject(TimeSynchronizeObject timeSynchronizeObject) {
		this.timeSynchronizeObject = timeSynchronizeObject;
	}

	public TMSOAMObject getTmsOamObject() {
		return tmsOamObject;
	}

	public void setTmsOamObject(TMSOAMObject tmsOamObject) {
		this.tmsOamObject = tmsOamObject;
	}

	public List<PHBToEXPObject> getPhbToEXPObject() {
		return phbToEXPObject;
	}

	public void setPhbToEXPObject(List<PHBToEXPObject> phbToEXPObject) {
		this.phbToEXPObject = phbToEXPObject;
	}

	public List<EXPToPHBObject> getExpToPHBObject() {
		return expToPHBObject;
	}

	public void setExpToPHBObject(List<EXPToPHBObject> expToPHBObject) {
		this.expToPHBObject = expToPHBObject;
	}

	public ClockObject getClockObject() {
		return clockObject;
	}

	public void setClockObject(ClockObject clockObject) {
		this.clockObject = clockObject;
	}

	public List<ETHLinkOAMObject> getEthLinkOAMObject() {
		return ethLinkOAMObject;
	}

	public void setEthLinkOAMObject(List<ETHLinkOAMObject> ethLinkOAMObject) {
		this.ethLinkOAMObject = ethLinkOAMObject;
	}

	public List<RoundProtectionObject> getRoundProtectionObject() {
		return roundProtectionObject;
	}

	public void setRoundProtectionObject(List<RoundProtectionObject> roundProtectionObject) {
		this.roundProtectionObject = roundProtectionObject;
	}

	public List<IGMPSNOOPINGObject> getIgmpsnooping() {
		return igmpsnooping;
	}

	public void setIgmpsnooping(List<IGMPSNOOPINGObject> igmpsnooping) {
		this.igmpsnooping = igmpsnooping;
	}

	public GlobalObject getGlobalObject() {
		return globalObject;
	}

	public void setGlobalObject(GlobalObject globalObject) {
		this.globalObject = globalObject;
	}

	public List<GroupSpreadObject> getGroupSpreadObject() {
		return groupSpreadObject;
	}

	public void setGroupSpreadObject(List<GroupSpreadObject> groupSpreadObject) {
		this.groupSpreadObject = groupSpreadObject;
	}

	public SingleObject getSingleObject() {
		return singleObject;
	}

	public void setSingleObject(SingleObject singleObject) {
		this.singleObject = singleObject;
	}

	public List<StaticUnicastObject> getStaticUnicast() {
		return staticUnicast;
	}

	public void setStaticUnicast(List<StaticUnicastObject> staticUnicast) {
		this.staticUnicast = staticUnicast;
	}

	public SinglePan getSinglePan() {
		return singlePan;
	}

	public void setSinglePan(SinglePan singlePan) {
		this.singlePan = singlePan;
	}

	public ResponsePan getResponsePan() {
		return responsePan;
	}

	public void setResponsePan(ResponsePan responsePan) {
		this.responsePan = responsePan;
	}

	public byte[] getBs() {
		return bs;
	}

	public void setBs(byte[] bs) {
		this.bs = bs;
	}

	public List<TMSOAMObject> getTmsoamObjects() {
		return tmsoamObjects;
	}

	public void setTmsoamObjects(List<TMSOAMObject> tmsoamObjects) {
		this.tmsoamObjects = tmsoamObjects;
	}
	
	public PmValueLimiteObject getPmValueLimiteObject() {
		return pmValueLimiteObject;
	}
	public void setPmValueLimiteObject(PmValueLimiteObject pmValueLimiteObject) {
		this.pmValueLimiteObject = pmValueLimiteObject;
	}
	public long getPerformanceBeginDataTime() {
		return performanceBeginDataTime;
	}
	public void setPerformanceBeginDataTime(long performanceBeginDataTime) {
		this.performanceBeginDataTime = performanceBeginDataTime;
	}
	public int getServicetType() {
		return servicetType;
	}
	public void setServicetType(int servicetType) {
		this.servicetType = servicetType;
	}
	public List<QinQObject> getQinQObjects() {
		return qinQObjects;
	}
	public void setQinQObjects(List<QinQObject> qinQObjects) {
		this.qinQObjects = qinQObjects;
	}
	public ETHOAMAllObject getEthoamAllObject() {
		return ethoamAllObject;
	}
	public void setEthoamAllObject(ETHOAMAllObject ethoamAllObject) {
		this.ethoamAllObject = ethoamAllObject;
	}
	public OamStatusObject getOamStatusObject() {
		return oamStatusObject;
	}
	public void setOamStatusObject(OamStatusObject oamStatusObject) {
		this.oamStatusObject = oamStatusObject;
	}
	public PingOrderControllerObject getPingOrderControllerObject() {
		return pingOrderControllerObject;
	}
	public void setPingOrderControllerObject(PingOrderControllerObject pingOrderControllerObject) {
		this.pingOrderControllerObject = pingOrderControllerObject;
	}
	public EthLoopObject getEthLoopObject() {
		return ethLoopObject;
	}
	public void setEthLoopObject(EthLoopObject ethLoopObject) {
		this.ethLoopObject = ethLoopObject;
	}
	public AclObject getAclObject() {
		return AclObject;
	}
	public void setAclObject(AclObject aclObject) {
		AclObject = aclObject;
	}
	public List<BlackWhiteMacObject> getBlackWhiteMacObjectList() {
		return blackWhiteMacObjectList;
	}
	public void setBlackWhiteMacObjectList(List<BlackWhiteMacObject> blackWhiteMacObjectList) {
		this.blackWhiteMacObjectList = blackWhiteMacObjectList;
	}
	public List<SmartFanObject> getSmartFanObjectList() {
		return smartFanObjectList;
	}
	public void setSmartFanObjectList(List<SmartFanObject> smartFanObjectList) {
		this.smartFanObjectList = smartFanObjectList;
	}
	public EthServiceObject getEthServiceObject() {
		return EthServiceObject;
	}
	public void setEthServiceObject(EthServiceObject ethServiceObject) {
		EthServiceObject = ethServiceObject;
	}
	public AlarmShieldObject getAlarmShieldObject() {
		return alarmShieldObject;
	}
	public void setAlarmShieldObject(AlarmShieldObject alarmShieldObject) {
		this.alarmShieldObject = alarmShieldObject;
	}
	public L2CPinfoObject getL2CPinfoObject() {
		return L2CPinfoObject;
	}
	public void setL2CPinfoObject(L2CPinfoObject l2cPinfoObject) {
		L2CPinfoObject = l2cPinfoObject;
	}
	
	public List<SecondMacStudyObject> getsecondMacStudyObjectList() {
		return secondMacStudyObjectList;
	}

	public void setSecondMacStudyObjectList(List<SecondMacStudyObject> secondMacStudyObjectList) {
		this.secondMacStudyObjectList = secondMacStudyObjectList;
	}
}
