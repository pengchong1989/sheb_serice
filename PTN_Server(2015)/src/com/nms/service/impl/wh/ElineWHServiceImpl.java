﻿package com.nms.service.impl.wh;

import java.util.ArrayList;
import java.util.List;

import com.nms.db.bean.equipment.port.E1Info;
import com.nms.db.bean.equipment.port.PortInst;
import com.nms.db.bean.ptn.path.ServiceInfo;
import com.nms.db.bean.ptn.path.ces.CesInfo;
import com.nms.db.bean.ptn.path.eth.DualInfo;
import com.nms.db.bean.ptn.path.eth.ElineInfo;
import com.nms.db.bean.ptn.path.pw.PwInfo;
import com.nms.db.bean.ptn.path.pw.PwNniInfo;
import com.nms.db.bean.ptn.port.AcPortInfo;
import com.nms.db.bean.ptn.port.Acbuffer;
import com.nms.db.bean.ptn.port.PortLagInfo;
import com.nms.db.bean.ptn.qos.QosInfo;
import com.nms.db.enums.EActiveStatus;
import com.nms.db.enums.ECesType;
import com.nms.db.enums.EManufacturer;
import com.nms.db.enums.EServiceType;
import com.nms.drive.service.bean.ELineObject;
import com.nms.drive.service.bean.NEObject;
import com.nms.drive.service.bean.VpwsBuffer;
import com.nms.model.equipment.port.E1InfoService_MB;
import com.nms.model.equipment.port.PortService_MB;
import com.nms.model.ptn.path.ces.CesInfoService_MB;
import com.nms.model.ptn.path.eth.DualInfoService_MB;
import com.nms.model.ptn.path.eth.ElineInfoService_MB;
import com.nms.model.ptn.path.pw.PwInfoService_MB;
import com.nms.model.ptn.port.AcBufferService_MB;
import com.nms.model.ptn.port.AcPortInfoService_MB;
import com.nms.model.ptn.port.PortLagService_MB;
import com.nms.model.util.Services;
import com.nms.service.OperationServiceI;
import com.nms.service.bean.ActionObject;
import com.nms.service.bean.OperationObject;
import com.nms.service.impl.base.WHOperationBase;
import com.nms.service.impl.util.ResultString;
import com.nms.service.impl.util.SiteUtil;
import com.nms.service.impl.util.SynchroUtil;
import com.nms.service.impl.util.WhImplUtil;
import com.nms.ui.manager.ConstantUtil;
import com.nms.ui.manager.DateUtil;
import com.nms.ui.manager.ExceptionManage;
import com.nms.ui.manager.UiUtil;

public class ElineWHServiceImpl extends WHOperationBase implements OperationServiceI {

	@Override
	public String excutionInsert(Object object) throws Exception {
		List<ElineInfo> elinList = new ArrayList<ElineInfo>();
		OperationObject operationObjectAfter = null;
		OperationObject operationObjectResult = null;
		ElineInfo eline = (ElineInfo) object;
		elinList.add(eline);
		/** 获取此Eline的所有网元ID */
		List<Integer> siteIdList = this.getSiteIds(elinList);
		SiteUtil siteUtil = new SiteUtil();
		operationObjectAfter = new OperationObject();
		if(siteIdList.size() > 0){
			for (Integer siteId : siteIdList) {
				try {
					if (true) {
						ActionObject actionObj = this.getActionObject(siteId);
						operationObjectAfter.getActionObjectList().add(actionObj);
					}
				} catch (Exception e) {
					return ResultString.CONFIG_FAILED;
				}
			}
			super.sendAction(operationObjectAfter);
			operationObjectResult = super.verification(operationObjectAfter);
			if (!operationObjectResult.isSuccess()) {
				return super.getErrorMessage(operationObjectResult);
			}
		}
		return ResultString.CONFIG_SUCCESS;
	}

	private ActionObject getActionObject(int siteId) throws Exception {
		WhImplUtil whImplUtil = new WhImplUtil();
		NEObject neObject = whImplUtil.siteIdToNeObject(siteId);
		ActionObject actionObject = new ActionObject();
		List<ActionObject> actionIdList = new ArrayList<ActionObject>();
		actionIdList.add(actionObject);
		actionObject.setActionId(super.getActionId(actionIdList));
		actionObject.setNeObject(neObject);
		actionObject.setType("eline");
		actionObject.setElineObjectList(this.getElineInfoObject(siteId));
		return actionObject;
	}

	@Override
	public String excutionUpdate(Object object) throws Exception {
		List<ElineInfo> elinList = new ArrayList<ElineInfo>();
		OperationObject operationObjectAfter = null;
		OperationObject operationObjectResult = null;
		ElineInfo eline = (ElineInfo) object;
		elinList.add(eline);
		/** 获取此Eline的所有网元ID */
		List<Integer> siteIdList = this.getSiteIds(elinList);
		SiteUtil siteUtil = new SiteUtil();
		operationObjectAfter = new OperationObject();
		if(siteIdList.size() > 0){
			for (Integer siteId : siteIdList) {
				try {
					if ("0".equals(siteUtil.SiteTypeUtil(siteId) + "")) {
						ActionObject actionObj = this.getActionObject(siteId);
						operationObjectAfter.getActionObjectList().add(actionObj);
					}
				} catch (Exception e) {
					return ResultString.CONFIG_FAILED;
				}
			}
			super.sendAction(operationObjectAfter);
			operationObjectResult = super.verification(operationObjectAfter);
			if (!operationObjectResult.isSuccess()) {
				return super.getErrorMessage(operationObjectResult);
			}
		}
		return ResultString.CONFIG_SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String excutionDelete(List objectList) throws Exception {
		OperationObject operationObjectAfter = null;
		OperationObject operationObjectResult = null;
		List<Integer> siteIdList = this.getSiteIds((List<ElineInfo>)objectList);
		SiteUtil siteUtil = new SiteUtil();
		operationObjectAfter = new OperationObject();
		if(siteIdList.size() > 0){
			for (Integer siteId : siteIdList) {
				try {
					if ("0".equals(siteUtil.SiteTypeUtil(siteId) + "")) {
						ActionObject actionObj = this.getActionObject(siteId);
						operationObjectAfter.getActionObjectList().add(actionObj);
					}
				} catch (Exception e) {
					return ResultString.CONFIG_FAILED;
				}
			}
			super.sendAction(operationObjectAfter);
			operationObjectResult = super.verification(operationObjectAfter);
			if (!operationObjectResult.isSuccess()) {
				return super.getErrorMessage(operationObjectResult);
			}
		}
		return ResultString.CONFIG_SUCCESS;
	}

	/**
	 * 获取网元id
	 * @param elineList
	 * @return
	 * @throws Exception
	 */
	private List<Integer> getSiteIds(List<ElineInfo> elineList){
		List<Integer> siteIds = null;
		try {
			siteIds = new ArrayList<Integer>();
			for (ElineInfo eline : elineList) {
				if (eline.getaSiteId() > 0) {
					if (!siteIds.contains(eline.getaSiteId()) && super.getManufacturer(eline.getaSiteId()) == EManufacturer.WUHAN.getValue()) {
						siteIds.add(eline.getaSiteId());
					}
				}
				if (eline.getzSiteId() > 0) {
					if (!siteIds.contains(eline.getzSiteId()) && super.getManufacturer(eline.getzSiteId()) == EManufacturer.WUHAN.getValue()) {
						siteIds.add(eline.getzSiteId());
					}
				}
			}
		} catch (Exception e) {
			ExceptionManage.dispose(e, this.getClass());
		}
		return siteIds;
	}

	/**
	 * 根据网元ID查询ELineObject
	 * 
	 * @param siteId
	 * @return
	 * @throws Exception
	 */
	private List<ELineObject> getElineInfoObject(int siteId) throws Exception {

		ElineInfoService_MB elineService = null;
		List<ElineInfo> elineInfoList = null;
		ELineObject eLineObject = null;
		ElineInfo eline = null;
		List<ELineObject> eLineObjectList = null;
		PwInfo pw = null;
		List<ElineInfo> activeList = null;
		List<CesInfo> cesInfoList = null;
		CesInfoService_MB cesInfoService = null;
		PortService_MB portService = null;
		PortInst portInst = null;
		DualInfoService_MB dualInfoService = null;
		List<DualInfo> dualInfos = null;
		E1InfoService_MB e1InfoService = null;
		try {
			elineService = (ElineInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.Eline);
			cesInfoService = (CesInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.CesInfo);
			portService = (PortService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PORT);
			dualInfoService = (DualInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.DUALINFO);
			e1InfoService = (E1InfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.E1Info);
			// 查询所有激活的eline
			eline = new ElineInfo();
			eline.setActiveStatus(EActiveStatus.ACTIVITY.getValue());
			elineInfoList = elineService.selectNodeBySite(siteId);
			eLineObjectList = new ArrayList<ELineObject>();
			activeList = new ArrayList<ElineInfo>();
			for (ElineInfo active : elineInfoList) {// 获取所有激活的eline
				if (active.getActiveStatus() == EActiveStatus.ACTIVITY.getValue())
					activeList.add(active);
			}
			// 查询ces业务
			cesInfoList = cesInfoService.selectNodeBySite(siteId);
			for (CesInfo cesInfo : cesInfoList) {
				if (cesInfo.getActiveStatus() == EActiveStatus.ACTIVITY.getValue()) {
					activeList.add(cesInfoTOElineInfo(cesInfo));
				}
			}
			
			//查询dual保护业务
			dualInfos = dualInfoService.selectBySiteId(siteId);
			for(DualInfo dualInfo : dualInfos){
				if(dualInfo.getActiveStatus() == EActiveStatus.ACTIVITY.getValue()){
					activeList.add(dualInfoToElineInfo(dualInfo));
				}
			}
			
			for (ElineInfo elineInfo : activeList) {
				pw = getPwInfo(elineInfo.getPwId());
				eLineObject = new ELineObject();
				// 匹配A网元
				if (elineInfo.getaSiteId() == siteId) {
					eLineObject.setVpwsId(elineInfo.getaXcId());
					eLineObject.setRole(0);
					eLineObject.setVpwsBufferList(getVpwsBuffer(elineInfo.getaAcId()));// vpwsbuffer赋值
					if (pw.getASiteId() == siteId) {
						eLineObject.setPwIdNNI(pw.getApwServiceId());
						configPwNniInfo(eLineObject, pw.getaPwNniInfo());// NNI端口赋值
					} else {
						eLineObject.setPwIdNNI(pw.getZpwServiceId());
						configPwNniInfo(eLineObject, pw.getzPwNniInfo());// NNI端口赋值
					}
					if (elineInfo.getCestype() != 3) {
						configAcInfo(eLineObject, elineInfo.getaAcId(), siteId);// UNI赋值	
					}
				}
				
				// 匹配Z网元
				if (elineInfo.getzSiteId() == siteId) {
					eLineObject.setRole(1);
					eLineObject.setVpwsId(elineInfo.getzXcId());
					eLineObject.setVpwsBufferList(getVpwsBuffer(elineInfo.getzAcId()));// vpwsbuffer赋值
					if (pw.getASiteId() == siteId) {
						eLineObject.setPwIdNNI(pw.getApwServiceId());
						configPwNniInfo(eLineObject, pw.getaPwNniInfo());// NNI端口赋值
					} else {
						eLineObject.setPwIdNNI(pw.getZpwServiceId());
						configPwNniInfo(eLineObject, pw.getzPwNniInfo());// NNI端口赋值
					}
					if (elineInfo.getCestype() != 3) {
						configAcInfo(eLineObject, elineInfo.getzAcId(), siteId);// UNI赋值
					}
				}
				
				if (elineInfo.getCestype() == 3) {
					E1Info e1Info = new E1Info();
					e1Info.setSiteId(siteId);
					VpwsBuffer vpwsBuffer = new VpwsBuffer();
					if (elineInfo.getaSiteId() == siteId) {
						e1Info.setPortId(elineInfo.getaAcId());
						portInst = portService.selectPortybyid(elineInfo.getaAcId());
					} else {
						e1Info.setPortId(elineInfo.getzAcId());
						portInst = portService.selectPortybyid(elineInfo.getzAcId());
					}
					List<E1Info> e1Infos = e1InfoService.selectByCondition(e1Info);
					if(e1Infos.size()>0){
						vpwsBuffer.setPwLable(e1Infos.get(0).getLegId());
					}
					vpwsBuffer.setVpwsBufferID(1);
					vpwsBuffer.setBufferEnable(1);
					eLineObject.setProtUNI(201);
					eLineObject.setSlotUNI(portInst.getSlotNumber());
					eLineObject.getVpwsBufferList().clear();
					eLineObject.getVpwsBufferList().add(vpwsBuffer);
				} 
				eLineObject.setType(elineInfo.getServiceType());
				eLineObjectList.add(eLineObject);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			elineInfoList = null;
			cesInfoList = null;
			UiUtil.closeService_MB(portService);
			UiUtil.closeService_MB(cesInfoService);
			UiUtil.closeService_MB(elineService);
			UiUtil.closeService_MB(dualInfoService);
			UiUtil.closeService_MB(e1InfoService);
		}
		return eLineObjectList;
	}

	/**
	 * 双归业务向eline业务转换
	 * @param dualInfo
	 * @return
	 */
	private ElineInfo dualInfoToElineInfo(DualInfo dualInfo){
		ElineInfo elineInfo = new ElineInfo();
		elineInfo.setName(dualInfo.getName());
		elineInfo.setActiveStatus(dualInfo.getActiveStatus());
		elineInfo.setPwId(dualInfo.getPwId());
		elineInfo.setIsSingle(dualInfo.getIsSingle());
		elineInfo.setServiceType(EServiceType.DUAL.getValue());
		elineInfo.setCestype(1);
		elineInfo.setCreateTime(DateUtil.getDate(DateUtil.FULLTIME));
		elineInfo.setaSiteId(dualInfo.getRootSite());
		elineInfo.setAportId(dualInfo.getAportId());
		elineInfo.setaAcId(dualInfo.getaAcId());
		elineInfo.setaXcId(dualInfo.getaXcId());
		if(dualInfo.getBranchMainSite()>0){
			elineInfo.setzSiteId(dualInfo.getBranchMainSite());
		}else if(dualInfo.getBranchProtectSite()>0){
			elineInfo.setzSiteId(dualInfo.getBranchProtectSite());
		}
		elineInfo.setZportId(dualInfo.getZportId());
		elineInfo.setzXcId(dualInfo.getzXcId());
		elineInfo.setzAcId(dualInfo.getzAcId());
		return elineInfo;
	}
	
	/**
	 * 对UNI端口进行赋值
	 * 
	 * @throws Exception
	 */
	private void configAcInfo(ELineObject eLineObject, int acId, int siteId) throws Exception {

		AcPortInfoService_MB acInfoService = null;
		AcPortInfo acPortInfo = null;
		List<Integer> idList = null;
		PortInst port = new PortInst();
		try {
			acInfoService = (AcPortInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.AcInfo);

			idList = new ArrayList<Integer>();
			idList.add(acId);
			acPortInfo = acInfoService.select(idList).get(0);
			if (acPortInfo.getLagId() > 0) {
				lagId(acPortInfo, eLineObject);
				eLineObject.setSlotUNI(20);
			} else {
				port = getportId(acPortInfo.getPortId(), siteId);
				eLineObject.setProtUNI(port.getNumber());
				eLineObject.setSlotUNI(port.getSlotNumber());
			}
			eLineObject.setModelUNI(Integer.parseInt(UiUtil.getCodeById(acPortInfo.getModel()).getCodeValue()));
			eLineObject.setCirUNI(acPortInfo.getSimpleQos().getCir()/1000);
			eLineObject.setPirUNI(acPortInfo.getSimpleQos().getPir()/1000);
			eLineObject.setCm(acPortInfo.getSimpleQos().getColorSence());
			eLineObject.setCbs(acPortInfo.getSimpleQos().getCbs());
			eLineObject.setPbs(acPortInfo.getSimpleQos().getPbs());
			eLineObject.settVCTrafficPolicing(Integer.parseInt(UiUtil.getCodeById(acPortInfo.getManagerEnable()).getCodeValue()));
			eLineObject.setDownTagUNI(Integer.parseInt(UiUtil.getCodeById(acPortInfo.getExitRule()).getCodeValue()));
			eLineObject.setUpTagUNI(Integer.parseInt(UiUtil.getCodeById(acPortInfo.getTagAction()).getCodeValue()));
			eLineObject.setVlanIdUNI(Integer.parseInt(acPortInfo.getVlanId()));
			eLineObject.setVlanPriUNI(Integer.parseInt(acPortInfo.getVlanpri()));
			eLineObject.setDownTpidUni(Integer.parseInt(UiUtil.getCodeById(acPortInfo.getDownTpid()).getCodeValue()));
		} catch (Exception e) {
			throw e;
		} finally {
			UiUtil.closeService_MB(acInfoService);
		}
	}

	private void lagId(AcPortInfo acPortInfo, ELineObject eLineObject) throws Exception {
		PortLagService_MB portLagService = null;
		PortLagInfo portLagInfo = null;
		try {
			portLagService = (PortLagService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PORTLAG);
			portLagInfo = new PortLagInfo();
			portLagInfo.setId(acPortInfo.getLagId());
			portLagInfo = portLagService.selectLAGByCondition(portLagInfo).get(0);
			eLineObject.setProtUNI(100+portLagInfo.getLagID());
			portLagInfo.setStatusActive(0);
			portLagService.saveOrUpdate(portLagInfo);

		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		} finally {
			UiUtil.closeService_MB(portLagService);
		}

	}

	private PortInst getportId(int portId, int siteId) {
		PortInst port = null;
		PortService_MB portService = null;
		try {
			portService = (PortService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PORT);
			port = new PortInst();
			port.setPortId(portId);
			port.setSiteId(siteId);
			List<PortInst> insts = portService.select(port);
			if (insts != null && insts.size() > 0) {
				port = portService.select(port).get(0);
			}
		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		} finally {
			UiUtil.closeService_MB(portService);
		}
		return port;
	}

	/**
	 * 对NNI端口进行赋值
	 * 
	 * @throws Exception
	 */
	private void configPwNniInfo(ELineObject eLineObject, PwNniInfo pwNniInfo) throws Exception {

		eLineObject.setDownTagNNI(Integer.parseInt(UiUtil.getCodeById(pwNniInfo.getExitRule()).getCodeValue()));
		eLineObject.setVlanIdNNI(Integer.parseInt(pwNniInfo.getSvlan()));
		eLineObject.setVlanPriNNI(Integer.parseInt(pwNniInfo.getVlanpri()));
		eLineObject.setUpTagNNI(Integer.parseInt(UiUtil.getCodeById(pwNniInfo.getTagAction()).getCodeValue()));
		eLineObject.setDownTpidNni(Integer.parseInt(UiUtil.getCodeById(pwNniInfo.getTpid()).getCodeValue()));
		eLineObject.setControlEnabl(Integer.parseInt(UiUtil.getCodeById(pwNniInfo.getControlEnable()).getCodeValue()));
	}

	/**
	 * 通过PWID和网元ID查询PW
	 * 
	 * @throws Exception
	 */
	private PwInfo getPwInfo(int pwid) throws Exception {

		PwInfo pwInfo = null;
		PwInfoService_MB pwInfoService = null;
		try {
			pwInfoService = (PwInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PwInfo);
			pwInfo = new PwInfo();
			pwInfo.setPwId(pwid);
			pwInfo = pwInfoService.selectBypwid_notjoin(pwInfo);
		} catch (Exception e) {
			throw e;
		} finally {
			UiUtil.closeService_MB(pwInfoService);
		}
		return pwInfo;
	}

	/**
	 * 通过acid对vpwsbuffer进行赋值
	 * 
	 * @throws Exception
	 */
	private List<VpwsBuffer> getVpwsBuffer(int acid) throws Exception {

		List<VpwsBuffer> vpwsBufferList = new ArrayList<VpwsBuffer>();
		List<Acbuffer> acbufferList = null;
		AcBufferService_MB uniBufferService = null;

		try {

			uniBufferService = (AcBufferService_MB) ConstantUtil.serviceFactory.newService_MB(Services.UniBuffer);
			acbufferList = uniBufferService.select(acid);
			int i = 0;
			for (Acbuffer acbuffer : acbufferList) {
				i++;
				VpwsBuffer vpwsBuffer = new VpwsBuffer();
				vpwsBuffer.setVpwsBufferID(i);
				vpwsBuffer.set_802_1P(acbuffer.getEightIp());
				vpwsBuffer.setBufferEnable(1);
				vpwsBuffer.setCbs(acbuffer.getCbs());
				vpwsBuffer.setCir(acbuffer.getCir()/1000);
				vpwsBuffer.setCm(acbuffer.getCm());
				vpwsBuffer.setIpDscp(acbuffer.getIpDscp());
				vpwsBuffer.setModel(acbuffer.getModel());
				vpwsBuffer.setPbs(acbuffer.getPbs());
				vpwsBuffer.setPhb(Integer.parseInt(UiUtil.getCodeById(acbuffer.getPhb()).getCodeValue()));
				vpwsBuffer.setPir(acbuffer.getPir()/1000);
				vpwsBuffer.setPwLable(0);
				vpwsBuffer.setSourceIP(acbuffer.getSourceIp());
				vpwsBuffer.setSourceMac(acbuffer.getSourceMac());
				vpwsBuffer.setTargetIP(acbuffer.getTargetIp());
				vpwsBuffer.setTargetMac(acbuffer.getTargetMac());
				vpwsBuffer.setVlanId(acbuffer.getVlanId());
				vpwsBuffer.setStrategy(acbuffer.getStrategy());
				vpwsBuffer.setSourceTcpPortId(acbuffer.getSourceTcpPortId());
				vpwsBuffer.setEndTcpPortId(acbuffer.getEndTcpPortId());
				vpwsBuffer.setIPTOS(acbuffer.getIPTOS());
				vpwsBuffer.setPortType(acbuffer.getPortType());
				vpwsBufferList.add(vpwsBuffer);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			UiUtil.closeService_MB(uniBufferService);
		}
		return vpwsBufferList;
	}

	/**
	 * 武汉（ces业务向eline业务转换）
	 * 
	 * @param cesInfo
	 * @return
	 */
	private ElineInfo cesInfoTOElineInfo(CesInfo cesInfo) {
		ElineInfo elineInfo = new ElineInfo();
		elineInfo.setName(cesInfo.getName());
		elineInfo.setActiveStatus(cesInfo.getActiveStatus());
		elineInfo.setPwId(cesInfo.getPwId());
		elineInfo.setIsSingle(cesInfo.getIsSingle());
		elineInfo.setServiceType(EServiceType.CES.getValue());
		elineInfo.setCestype(3);
		elineInfo.setCreateTime(DateUtil.getDate(DateUtil.FULLTIME));
		//TODO user
//		elineInfo.setCreateUser(ConstantUtil.user.getUser_Name());
		elineInfo.setaSiteId(cesInfo.getaSiteId());
		elineInfo.setAportId(cesInfo.getAportId());
		elineInfo.setaXcId(cesInfo.getAxcId());
		elineInfo.setzSiteId(cesInfo.getzSiteId());
		elineInfo.setZportId(cesInfo.getZportId());
		elineInfo.setzXcId(cesInfo.getZxcId());
		elineInfo.setaAcId(cesInfo.getaAcId());
		elineInfo.setzAcId(cesInfo.getzAcId());
		return elineInfo;
	}

	@Override
	public Object synchro(int siteId) {
		OperationObject operaObj = new OperationObject();
		ElineInfoService_MB elineService = null;
		DualWHServceImpl dualWHServceImpl = new DualWHServceImpl();
		try {
			operaObj = this.getSynchroOperationObject(siteId);// 封装下发数据
			super.sendAction(operaObj);// 下发数据
			super.verification(operaObj);// 验证是否下发成功
			if (operaObj.isSuccess()) {
				/* 成功，则与数据库进行同步 */
				elineService = (ElineInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.Eline);
				for (ActionObject actionObject : operaObj.getActionObjectList()) {
					//把所有VPWS业务修改为未激活
					elineService.updateActiveStatusByType(siteId, EActiveStatus.UNACTIVITY.getValue(), EServiceType.ELINE.getValue());
					elineService.updateActiveStatusByType(siteId, EActiveStatus.UNACTIVITY.getValue(), EServiceType.CES.getValue());
					elineService.updateActiveStatusByType(siteId, EActiveStatus.UNACTIVITY.getValue(), EServiceType.DUAL.getValue());
					this.synchro_db(actionObject.getElineObjectList(), siteId);
				}
			}
			dualWHServceImpl.synchro(siteId);
			return ResultString.CONFIG_SUCCESS;
		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		} finally {
			UiUtil.closeService_MB(elineService);
		}
		return "超时";
	}

	/**
	 * 同步
	 * 
	 * @param elineObjectList
	 * @param siteId
	 */
	private void synchro_db(List<ELineObject> elineObjectList, int siteId) {
		ElineInfo elineInfo = null;
		AcPortInfo acPortInfo = null;
		PwNniInfo pwNniInfo = null;
		CesInfo cesInfo = null;
		DualInfo dualInfo = null;
		AcPortInfoService_MB acInfoService = null;
		int serviceId = 1;
		try {
			SynchroUtil synchroUtil = new SynchroUtil();
			for (ELineObject eLineObject : elineObjectList) {
				if (eLineObject.getType() == 0) {// 同步CES业务
					pwNniInfo = this.getPwNniInfo(eLineObject, siteId);
					synchroUtil.pwNniBufferInfoSynchro(pwNniInfo, siteId, false);
					cesInfo = this.getCesInfo(eLineObject, siteId);
					synchroUtil.CesSynchro(cesInfo, siteId);
				} 
//				else if(eLineObject.getType() == 1){// eline
				else{
					int acId = 0;
					try {
						acPortInfo = this.getAcPortInfo(eLineObject, siteId);
						acId = synchroUtil.acPortInfoSynchro(acPortInfo, siteId);
					} catch (Exception e) {
						ExceptionManage.dispose(e, this.getClass());
						continue;
					}
					try {
						if(eLineObject.getType() == 1)
						{
							elineInfo = this.getElineInfo(eLineObject, siteId, acId, eLineObject.getType());
						}else if(eLineObject.getType() == EServiceType.DUAL.getValue())
						{
							dualInfo =this.getDualInfo(eLineObject, siteId,acId,serviceId);
						}
					} catch (Exception e) {
						ExceptionManage.dispose(e, this.getClass());
						acInfoService = (AcPortInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.AcInfo);
						List<Integer> acIdList = new ArrayList<Integer>();
						acIdList.add(acId);
						acInfoService.updateState(acIdList);
						continue;
					}
					pwNniInfo = this.getPwNniInfo(eLineObject, siteId);
					if(eLineObject.getType() == 1)
					{
						synchroUtil.elineSynchro(elineInfo, siteId);
					}else if(eLineObject.getType() == EServiceType.DUAL.getValue())
					{
						synchroUtil.dualSynchro(dualInfo, siteId);
					}
					synchroUtil.pwNniBufferInfoSynchro(pwNniInfo, siteId, false);
				}
				serviceId++;
			}
		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		}finally{
			UiUtil.closeService_MB(acInfoService);
		}
	}

	/**
	 * 封装pwNniBuffer
	 * 
	 * @param elineObjectList
	 * @param siteId
	 * @return
	 * @throws Exception
	 */
	private PwNniInfo getPwNniInfo(ELineObject eLineObject, int siteId) throws Exception {
		PwInfoService_MB pwInfoService = null;
		PwInfo pwinfo = null;
		PwNniInfo pwNniInfo = null;
		try {
			pwInfoService = (PwInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PwInfo);
			pwNniInfo = new PwNniInfo();
			pwNniInfo.setSiteId(siteId);
			pwinfo = pwInfoService.select(siteId, eLineObject.getPwIdNNI());
			pwNniInfo.setPwId(pwinfo.getPwId());
			pwNniInfo.setTagAction(UiUtil.getCodeByValue("TAGRECOGNITION", eLineObject.getUpTagNNI() + "").getId());
			pwNniInfo.setExitRule(UiUtil.getCodeByValue("PORTTAGBEHAVIOR", eLineObject.getDownTagNNI() + "").getId());
			pwNniInfo.setSvlan(eLineObject.getVlanIdNNI() + "");
			pwNniInfo.setVlanpri(eLineObject.getVlanPriNNI() + "");
			pwNniInfo.setControlEnable(UiUtil.getCodeByValue("ENABLEDSTATUE", eLineObject.getControlEnabl() + "").getId());
//			pwNniInfo.setMacAddressLearn(UiUtil.getCodeByValue("MACLEARN", 1 + "").getId());
//			pwNniInfo.setHorizontalDivision(UiUtil.getCodeByValue("VCTRAFFICPOLICING", 1 + "").getId());
			pwNniInfo.setPwBusinessId(eLineObject.getPwIdNNI());
		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		} finally {
			UiUtil.closeService_MB(pwInfoService);
		}

		return pwNniInfo;
	}

	/**
	 * 封装acinfo
	 * 
	 * @param elineObjectList
	 * @param siteId
	 * @return
	 */
	private AcPortInfo getAcPortInfo(ELineObject eLineObject, int siteId) {
		AcPortInfo acPortInfo = null;
		PortInst portInst = null;
		PortService_MB portService = null;
		PortLagService_MB portLagService = null;
		PortLagInfo portLagInfo = null;
		QosInfo simpleQos = null;
		try {
			acPortInfo = new AcPortInfo();
			int portModel = 0;
			if (eLineObject.getProtUNI() < 100) {
				portService = (PortService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PORT);
				portInst = new PortInst();
				portInst.setNumber(eLineObject.getProtUNI());
				portInst.setSiteId(siteId);
				portInst = portService.select(portInst).get(0);
				acPortInfo.setPortId(portInst.getPortId());
				portModel = portInst.getPortAttr().getPortUniAttr().getVlanRelevance() == 51?1:0;
			} else if (eLineObject.getProtUNI() != 201) {
				portLagService = (PortLagService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PORTLAG);
				portLagInfo = new PortLagInfo();
				portLagInfo.setSiteId(siteId);
				portLagInfo.setLagID(eLineObject.getProtUNI() - 100);
				portLagInfo = portLagService.selectLAGByCondition(portLagInfo).get(0);
				acPortInfo.setLagId(portLagInfo.getId());
			}
			simpleQos = new QosInfo();
			acPortInfo.setSiteId(siteId);

			// simpleQos.setqos(eLineObject.getCir());
			simpleQos.setPir(eLineObject.getPirUNI()*1000);
			simpleQos.setCir(eLineObject.getCirUNI()*1000);
			simpleQos.setCbs(eLineObject.getCbs());
			simpleQos.setPbs(eLineObject.getPbs());
			simpleQos.setCos(5);//武汉的协议中，简单qos没有cos
			simpleQos.setQosType("L2");
			acPortInfo.setTagAction(UiUtil.getCodeByValue("TAGRECOGNITION", eLineObject.getUpTagUNI() + "").getId());
			acPortInfo.setExitRule(UiUtil.getCodeByValue("PORTTAGBEHAVIOR", eLineObject.getDownTagUNI() + "").getId());
			acPortInfo.setVlanId(eLineObject.getVlanIdUNI() + "");
			acPortInfo.setVlanpri(eLineObject.getVlanPriUNI() + "");
			acPortInfo.setManagerEnable(UiUtil.getCodeByValue("VCTRAFFICPOLICING", eLineObject.gettVCTrafficPolicing() + "").getId());
			acPortInfo.setModel(UiUtil.getCodeByValue("MODEL", eLineObject.getModelUNI() + "").getId());
			acPortInfo.setMacAddressLearn(UiUtil.getCodeByValue("MACLEARN", 0+"").getId());//eline无该属性，etree有该属性
			acPortInfo.setHorizontalDivision(UiUtil.getCodeByValue("VCTRAFFICPOLICING", 0+"").getId());//eline无该属性，etree有该属性
			acPortInfo.setName("ac_eline" + eLineObject.getVpwsId());
			acPortInfo.setAcStatus(EActiveStatus.ACTIVITY.getValue());
			// acPortInfo.setBufType(uniObj);
			acPortInfo.setBufferList(getacbuffer(eLineObject, eLineObject.getProtUNI(), siteId));
			acPortInfo.setPortModel(UiUtil.getCodeByValue("UNIPORTMODE", portModel+"").getId());
			acPortInfo.setSimpleQos(simpleQos);
			acPortInfo.setIsUser(1);
		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		} finally {
			UiUtil.closeService_MB(portService);
			UiUtil.closeService_MB(portLagService);
		}
		return acPortInfo;
	}

	/**
	 * 封装ac对应的acbuffer
	 * 
	 * @param eLineObject
	 * @param portNumber
	 * @param siteId
	 * @return
	 * @throws Exception
	 */
	private List<Acbuffer> getacbuffer(ELineObject eLineObject, int portNumber, int siteId) throws Exception {
		List<Acbuffer> acbufferList = new ArrayList<Acbuffer>();
		// if(portNumber<100){
		for (VpwsBuffer vpwsBuffer : eLineObject.getVpwsBufferList()) {
			try {
				Acbuffer acbuffer = new Acbuffer();
				acbuffer.setBufferEnable(vpwsBuffer.getBufferEnable());
				acbuffer.setVlanId(vpwsBuffer.getVlanId());
				acbuffer.setSourceMac(vpwsBuffer.getSourceMac());
				acbuffer.setTargetMac(vpwsBuffer.getTargetMac());
				acbuffer.setEightIp(vpwsBuffer.get_802_1P());
				acbuffer.setSourceIp(vpwsBuffer.getSourceIP());
				acbuffer.setTargetIp(vpwsBuffer.getTargetIP());
				acbuffer.setIpDscp(vpwsBuffer.getIpDscp());
				acbuffer.setModel(vpwsBuffer.getModel());
				acbuffer.setCir(vpwsBuffer.getCir()*1000);
				acbuffer.setPir(vpwsBuffer.getPir()*1000);
				acbuffer.setCm(vpwsBuffer.getCm());
				acbuffer.setCbs(vpwsBuffer.getCbs());
				acbuffer.setPbs(vpwsBuffer.getPbs());
				acbuffer.setStrategy(vpwsBuffer.getStrategy());
				acbuffer.setPhb(UiUtil.getCodeByValue("CONRIRMPHB", vpwsBuffer.getPhb() + "").getId());
				acbuffer.setSourceTcpPortId(vpwsBuffer.getSourceTcpPortId());
				acbuffer.setEndTcpPortId(vpwsBuffer.getEndTcpPortId());
				acbuffer.setIPTOS(vpwsBuffer.getIPTOS());
				acbuffer.setPortType(vpwsBuffer.getPortType());
				acbufferList.add(acbuffer);
			} catch (Exception e) {
				ExceptionManage.dispose(e,this.getClass());
			}
		}
		// }
		return acbufferList;
	}

	/**
	 * 封装elineInfo
	 * 
	 * @param elineObjectList
	 * @param siteId
	 * @param acId2 
	 * @return
	 * @throws Exception 
	 */
	private ElineInfo getElineInfo(ELineObject eLineObject, int siteId,int acId,int type) throws Exception {
		PwInfoService_MB pwInfoService = null;
		PwInfo pwinfo = null;
		ElineInfo elineInfo = null;
		try {
			pwInfoService = (PwInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PwInfo);
			elineInfo = new ElineInfo();
			if(eLineObject.getRole() == 0){
				elineInfo.setaXcId(eLineObject.getVpwsId());
				elineInfo.setaSiteId(siteId);
				elineInfo.setaAcId(acId);
			}else{
				elineInfo.setzXcId(eLineObject.getVpwsId());
				elineInfo.setzSiteId(siteId);
				elineInfo.setzAcId(acId);
			}
			
			pwinfo = pwInfoService.select(siteId, eLineObject.getPwIdNNI());
			elineInfo.setPwId(pwinfo.getPwId());
			elineInfo.setServiceType(type);
			elineInfo.setName("eline" + eLineObject.getVpwsId());
			elineInfo.setActiveStatus(EActiveStatus.ACTIVITY.getValue());
			elineInfo.setIsSingle(1);
		} catch (Exception e) {
			throw e;
		}finally{
			pwinfo = null;
			UiUtil.closeService_MB(pwInfoService);
		}
		return elineInfo;
	}

	/**
	 * 封装elineInfo
	 * 
	 * @param elineObjectList
	 * @param siteId
	 * @return
	 */
	private CesInfo getCesInfo(ELineObject eLineObject, int siteId) {
		PwInfoService_MB pwInfoService = null;
		PwInfo pwinfo = null;
		CesInfo cesInfo = null;
		E1InfoService_MB e1InfoService = null;
		List<E1Info> e1Infos = null;
		try {
			pwInfoService = (PwInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PwInfo);
			e1InfoService = (E1InfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.E1Info);
			e1Infos = e1InfoService.selectBySiteId(siteId);
			E1Info e1Info = new E1Info();
			e1Info.setSiteId(siteId);
			e1Info.setLegId(eLineObject.getVpwsBufferList().get(0).getPwLable());
			e1Infos = e1InfoService.selectByCondition(e1Info);
			if(e1Infos.size()>0){
				e1Info = e1Infos.get(0);
			}
			cesInfo = new CesInfo();
			pwinfo = pwInfoService.select(siteId, eLineObject.getPwIdNNI());
			if(eLineObject.getRole() == 0){
				cesInfo.setAxcId(eLineObject.getVpwsId());
				cesInfo.setaSiteId(siteId);
				cesInfo.setaAcId(e1Info.getPortId());
			}else{
				cesInfo.setZxcId(eLineObject.getVpwsId());
				cesInfo.setzSiteId(siteId);
				cesInfo.setzAcId(e1Info.getPortId());
			}
			cesInfo.setPwId(pwinfo.getPwId());
			cesInfo.setServiceType(EServiceType.CES.getValue());
			cesInfo.setCestype(ECesType.PDH.getValue());
			cesInfo.setName("ces_" + eLineObject.getVpwsId());
			cesInfo.setActiveStatus(EActiveStatus.ACTIVITY.getValue());
			cesInfo.setIsSingle(1);
		} catch (Exception e) {
			ExceptionManage.dispose(e, this.getClass());
		} finally {
			UiUtil.closeService_MB(e1InfoService);
			UiUtil.closeService_MB(pwInfoService);
		}
		return cesInfo;
	}

    /****************获取详细的dual对象信息**********************/
	private DualInfo getDualInfo(ELineObject eLineObject, int siteId,int acId,int serviceId) throws Exception{
		DualInfo dualInfo = null;
		PwInfoService_MB pwInfoService = null;
		PwInfo pwinfo = null;
		try {
			pwInfoService = (PwInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PwInfo);
			dualInfo = new DualInfo();
			if(eLineObject.getRole() == 0){
				dualInfo.setaXcId(eLineObject.getVpwsId());
				dualInfo.setaSiteId(siteId);
				dualInfo.setRootSite(siteId);
				dualInfo.setaAcId(acId);
			}else{
				dualInfo.setzXcId(eLineObject.getVpwsId());
				dualInfo.setzSiteId(siteId);
				dualInfo.setzAcId(acId);
			}
			
			pwinfo = pwInfoService.select(siteId, eLineObject.getPwIdNNI());
			dualInfo.setPwId(pwinfo.getPwId());
			dualInfo.setCreateTime(DateUtil.getDate(DateUtil.FULLTIME));
			dualInfo.setServiceId(serviceId);
			dualInfo.setServiceType(EServiceType.DUAL.getValue());
			dualInfo.setName("dual-" + serviceId);
			dualInfo.setActiveStatus(EActiveStatus.ACTIVITY.getValue());
			dualInfo.setIsSingle(1);
		} catch (Exception e) {
			throw e;
		}finally{
			pwinfo = null;
			UiUtil.closeService_MB(pwInfoService);
		}
		return dualInfo;
	}
	/**
	 * 封装下发数据
	 * 
	 * @param siteId
	 * @return operationObject
	 * @throws Exception
	 */
	private OperationObject getSynchroOperationObject(int siteId) throws Exception {
		OperationObject operationObject = null;
		ActionObject actionObject = null;
		NEObject neObject = null;
		try {
			WhImplUtil whImplUtil = new WhImplUtil();
			operationObject = new OperationObject();
			neObject = whImplUtil.siteIdToNeObject(siteId);
			actionObject = new ActionObject();
			actionObject.setActionId(super.getActionId(operationObject.getActionObjectList()));
			actionObject.setNeObject(neObject);
			actionObject.setType("elineSynchro");
			operationObject.getActionObjectList().add(actionObject);
		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		} finally {
			actionObject = null;
		}
		return operationObject;
	}
	
	/**
	 * 返回设备数据
	 * @param siteId
	 * @return
	 */
	public List<ServiceInfo> consistence(int siteId){
		List<ServiceInfo> serviceInfoList = new ArrayList<ServiceInfo>();
		try {
			OperationObject operaObj = this.getSynchroOperationObject(siteId);// 封装下发数据
			super.sendAction(operaObj);// 下发数据
			super.verification(operaObj);// 验证是否下发成功
			if (operaObj.isSuccess()) {
				for (ActionObject actionObject : operaObj.getActionObjectList()) {
					serviceInfoList = this.getElineInfo(actionObject.getElineObjectList(), siteId);
					return serviceInfoList;
				}
			}
		} catch (Exception e) {
			ExceptionManage.dispose(e, this.getClass());
		}
		return serviceInfoList;
	}

	private List<ServiceInfo> getElineInfo(List<ELineObject> elineObjectList, int siteId){
		List<ServiceInfo> elineList = new ArrayList<ServiceInfo>();
		for (ELineObject eLineObject : elineObjectList) {
			try {
				if (eLineObject.getType() == 1) {// 同步eline业务
					AcPortInfo acPortInfo = this.getAcPortInfo(eLineObject, siteId);
					ElineInfo elineInfo = this.getElineInfo(eLineObject, siteId, acPortInfo.getId(),eLineObject.getType());
					PwNniInfo pwNniInfo = this.getPwNniInfo(eLineObject, siteId);
					elineInfo.getAcPortList().add(acPortInfo);
					elineInfo.getPwNniList().add(pwNniInfo);
					elineList.add(elineInfo);
				} else if(eLineObject.getType() == 0){// 同步CES业务
					PwNniInfo pwNniInfo = this.getPwNniInfo(eLineObject, siteId);
					CesInfo cesInfo = this.getCesInfo(eLineObject, siteId);
					cesInfo.getPwNniList().add(pwNniInfo);
					elineList.add(cesInfo);
				}
			} catch (Exception e) {
				ExceptionManage.dispose(e, this.getClass());
			}
		}
		return elineList;
	}
}
