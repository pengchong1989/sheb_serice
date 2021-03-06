package com.nms.drive.analysis.xmltool.test;

import com.nms.ui.manager.ExceptionManage;

public class TESTAnalysisDriveXmlToCommand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		try {

			String[] commands = new String[] { "P", "Z", "04", "09", "流水号", "方向", "对象范围", "对象标识号1", "对象标识号2", "对象标识号3", "对象标识号4", "状态1", "状态2", "备用1", "备用2", "备用3", "备用4", "长度1", "长度2", "长度3", "长度4", "主控盘开关(高)", "主控盘开关(低)", "管理数据标识=01", "(配置日期时间)年", "年", "月", "日", "时", "分", "秒", "(配置版本)02", "00", "版本3", "版本4", "版本5", "超级用户口令1", "超级用户口令2", "超级用户口令3", "超级用户口令4", "超级用户口令5", "超级用户口令6", "超级用户口令7", "超级用户口令8", "一般用户口令1", "一般用户口令2", "一般用户口令3", "一般用户口令4", "一般用户口令5", "一般用户口令6", "一般用户口令7", "一般用户口令8", "2", "工作站号1", "工作站网址1", "工作站网址2", "工作站网址3", "工作站网址4", "工作站网址5", "工作站网址6", "工作站网址7", "工作站网址8", "工作站网址9", "工作站网址10", "工作站网址11", "工作站网址12", "工作站网址13", "工作站网址14", "2", "工作站1的用户1", "工作站1的用户2", "工作站号2", "工作站网址1", "工作站网址2", "工作站网址3", "工作站网址4", "工作站网址5", "工作站网址6", "工作站网址7", "工作站网址8", "工作站网址9", "工作站网址10",
					"工作站网址11", "工作站网址12", "工作站网址13", "工作站网址14", "2", "工作站1的用户1", "工作站1的用户2", "域地址11", "域地址12", "域地址13", "域地址14", "域地址15", "域地址16", "域地址17", "域地址18", "域地址19", "域地址110", "域地址111", "域地址21", "域地址22", "域地址23", "域地址24", "域地址25", "域地址26", "域地址27", "域地址28", "域地址29", "域地址210", "域地址211", "域地址1状态", "域地址2状态", "备用1", "备用2", "备用3", "备用4", "备用5", "备用6", "备用7", "备用8", "备用9", "备用10", "备用11", "备用12", "备用13", "备用14", "2", "主控盘1开关1", "主控盘1开关2", "主控盘1类型", "2", "主控盘1对应的NE1地址1", "主控盘1对应的NE1地址2", "主控盘1对应的NE2地址1", "主控盘1对应的NE2地址2", "MCF网络字11", "MCF网络字12", "MCF网络字13", "MCF网络字14", "MCF网络字15", "MCF网络字16", "MCF网络字17", "MCF网络字18", "主控盘1的以太网IP地址1", "主控盘1的以太网IP地址2", "主控盘1的以太网IP地址3", "主控盘1的IP以太网地址4", "主控盘1的以太网子网屏蔽1", "主控盘1的以太网子网屏蔽2", "主控盘1的以太网子网屏蔽3", "主控盘1的以太网子网屏蔽4", "主控盘1的以太网网关1", "主控盘1的以太网网关2",
					"主控盘1的以太网网关3", "主控盘1的以太网网关4", "主控盘1的PPP的IP地址1", "主控盘1的PPP的IP地址2", "主控盘1的PPP的IP地址3", "主控盘1的PPP的IP地址4", "主控盘1的PPP的子网屏蔽1", "主控盘1的PPP的子网屏蔽2", "主控盘1的PPP的子网屏蔽3", "主控盘1的PPP的子网屏蔽4", "MCF网络字129", "MCF网络字130", "MCF网络字131", "MCF网络字132", "主控盘1对应的段号", "主控盘1盘类型", "WDM类别", "备用", "主控盘2开关1", "主控盘2开关2", "主控盘2类型", "2", "主控盘2对应的NE1地址1", "主控盘2对应的NE1地址2", "主控盘2对应的NE2地址1", "主控盘2对应的NE2地址2", "MCF网络字11", "MCF网络字12", "MCF网络字13", "MCF网络字14", "MCF网络字15", "MCF网络字16", "MCF网络字17", "MCF网络字18", "主控盘2的以太网IP地址1", "主控盘2的以太网IP地址2", "主控盘2的以太网IP地址3", "主控盘2的IP以太网地址4", "主控盘2的以太网子网屏蔽1", "主控盘2的以太网子网屏蔽2", "主控盘2的以太网子网屏蔽3", "主控盘2的以太网子网屏蔽4", "主控盘2的以太网网关1", "主控盘2的以太网网关2", "主控盘2的以太网网关3", "主控盘2的以太网网关4", "主控盘2的PPP的IP地址1", "主控盘2的PPP的IP地址2", "主控盘2的PPP的IP地址3", "主控盘2的PPP的IP地址4", "主控盘2的PPP的子网屏蔽1", "主控盘2的PPP的子网屏蔽2",
					"主控盘2的PPP的子网屏蔽3", "主控盘2的PPP的子网屏蔽4", "MCF网络字129", "MCF网络字130", "MCF网络字131", "MCF网络字132", "主控盘2对应的段号", "主控盘2盘类型", "WDM类别", "备用" };

//			String xmlpath = "C:\\Documents and Settings\\tongxc\\桌面\\PZO4OC.xml";
//			AnalysisCommandByDriveXml AnalysisCommandByDriveXml = new AnalysisCommandByDriveXml();
//			AnalysisCommandByDriveXml.setCommands(commands);
//			DriveRoot driveRoot = AnalysisCommandByDriveXml.analysisDriveAttrbute(xmlpath);
//
//			AnalysisDriveXmlToCommand AnalysisDriveXmlToCommand = new AnalysisDriveXmlToCommand();
//			String[] commands2 = AnalysisDriveXmlToCommand.analysisCommands(driveRoot);
//			System.out.println();
		} catch (Exception e) {
			ExceptionManage.dispose(e,TESTAnalysisDriveXmlToCommand.class);
		}
	}

}
