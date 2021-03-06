package com.seu.ui.cal.input;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.seu.adapter.UiAdapter;
import com.seu.adapter.UiEmAdapter;
import com.seu.bean.EM;
import com.seu.bean.Size;
import com.seu.bean.Version;
import com.seu.dao.impl.EMDaoImpl;
import com.seu.dao.impl.SizeDaoImpl;
import com.seu.exception.EmMissingParamException;
import com.seu.exception.EmNotFoundException;
import com.seu.exception.InvalidInputException;
import com.seu.exception.SizeNotFoundException;
import com.seu.exception.VersionNotSelectedException;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class CalEMEnterCp extends Composite implements UiEmAdapter{
	private Label lblhorizontal;
	private Label lblhorizontal1;
	private Text textEM;
	private Version version;
	private EM em;
	private Combo cbRELY ;
	private Combo cbDOCU ;
	private Combo cbSTOR ;
	private Combo cbACAP ;
	private Combo cbPCAP ;
	private Combo cbPLEX ;
	private Combo cbTOOL ;
	private Combo cbCPLX ;
	private Combo cbTIME ;
	private Combo cbPVOL ;
	private Combo cbPCON ;
	private Combo cbAPEX ;
	private Combo cbLTEX ;
	private Combo cbSITE ; 
	private Combo cbSCED;
	private final int	RELY =1;
	private final int	DOCU =2;
	private final int	STOR =3;
	private final int	ACAP =4;
	private final int	PCAP =5;
	private final int	PLEX =6;
	private final int	TOOL =7;
	private final int	CPLX =8;
	private final int	TIME =9;
	private final int	PVOL =10;
	private final int	PCON =11;
	private final int	APEX =12;
	private final int	LTEX =13;
	private final int	SITE =14;
	private final int	SCED =15;
	private final float	vsRELY[] ={1.23f,1.1f,1.0f,0.99f,1.07f};
	private final float	vsDOCU[] ={0.81f,0.91f,1.0f,1.11f,1.23f};
	private final float	vsSTOR[] ={1.00f,1.05f,1.17f,1.46f};
	private final float	vsACAP[] ={1.42f,1.19f,1.00f,0.85f,0.71f};
	private final float	vsPCAP[] ={1.34f,1.15f,1.00f,0.88f,0.76f};
	private final float	vsPLEX[] ={1.19f,1.09f,1.00f,0.91f,0.85f};
	private final float	vsTOOL[] ={1.17f,1.09f,1.00f,0.90f,0.78f};
	private final float	vsCPLX[] ={0.73f,0.87f,1.00f,1.17f,1.34f,1.74f};
	private final float	vsTIME[] ={1.0f,1.11f,1.29f,1.63f};
	private final float	vsPVOL[] ={0.87f,1.00f,1.15f,1.30f};
	private final float	vsPCON[] ={1.29f,1.12f,1.00f,0.90f,0.81f};
	private final float	vsAPEX[] ={1.22f,1.10f,1.00f,0.88f,0.81f};
	private final float	vsLTEX[] ={1.20f,1.09f,1.00f,0.91f,0.84f};
	private final float	vsSITE[] ={1.22f,1.09f,1.00f,0.93f,0.86f,0.80f};
	private final float vsSCED[] ={1.43f,1.14f,1.00f,1.00f,1.00f};
	ArrayList<float[]> alist=new ArrayList<float[]>();
/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CalEMEnterCp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
	
		alist.add(vsRELY);
		alist.add(vsDOCU);
		alist.add(vsSTOR);
		alist.add(vsACAP);
		alist.add(vsPCAP);
		alist.add(vsPLEX);
		alist.add(vsTOOL);
		alist.add(vsCPLX);
		alist.add(vsTIME);
		alist.add(vsPVOL);
		alist.add(vsPCON);
		alist.add(vsAPEX);
		alist.add(vsLTEX);
		alist.add(vsSITE);
		alist.add(vsSCED);
//		for (int type=1;type<=14;type++){
//			for(int i=0;i<alist.get(type-1).length;i++)
//			{	
//				System.out.println(type+"  "+alist.get(type-1)[i]);	
//			}
//		}
		initLayot();
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}


	
	@Override
	public void load() {
		// TODO 自动生成的方法存根
		if(version!=null){
			EMDaoImpl emDaoImpl = new EMDaoImpl();
			try {
				em = emDaoImpl.getByProj_idAndVersion_idAndType(version.getProj_id(), version.getId(),0);
				if(em.getInputEm()==0.0f)
					textEM.setText("");
				else {
					textEM.setText(em.getInputEm()+"");
				}
				if(isCbEnabled())
				{
					cbRELY.select(getEmIndex(1, em.getRELY()));
					cbDOCU.select(getEmIndex(2, em.getDOCU()));
					cbSTOR.select(getEmIndex(3, em.getSTOR()));
					cbACAP.select(getEmIndex(4, em.getACAP()));
					cbPCAP.select(getEmIndex(5, em.getPCAP()));
					cbPLEX.select(getEmIndex(6, em.getPLEX()));
					cbTOOL.select(getEmIndex(7, em.getTOOL()));
					cbCPLX.select(getEmIndex(8, em.getCPLX()));
					cbTIME.select(getEmIndex(9, em.getTIME()));
					cbPVOL.select(getEmIndex(10,em.getPVOL()));
					cbPCON.select(getEmIndex(11,em.getPCON()));
					cbAPEX.select(getEmIndex(12,em.getAPEX()));
					cbLTEX.select(getEmIndex(13,em.getLTEX()));
					cbSITE.select(getEmIndex(14,em.getSITE()));
					cbSCED.select(getEmIndex(15,em.getSCED()));
				}
				
				
			} catch (EmNotFoundException e) {
				// TODO 自动生成的 catch 块
				cbRELY.deselectAll();
				cbDOCU.deselectAll();
				cbSTOR.deselectAll();
				cbACAP.deselectAll();
				cbPCAP.deselectAll();
				cbPLEX.deselectAll();
				cbTOOL.deselectAll();
				cbCPLX.deselectAll();
				cbTIME.deselectAll();
				cbPVOL.deselectAll();
				cbPCON.deselectAll();
				cbAPEX.deselectAll();
				cbLTEX.deselectAll();
				cbSITE.deselectAll();
				cbSCED.deselectAll();
				textEM.setText("");
				System.out.println("暂时无em版本，请添加");
			}
		}
	}

	@Override
	public void refresh() {
		// TODO 自动生成的方法存根
		load();
	}

	@Override
	public void save() throws EmMissingParamException,VersionNotSelectedException,InvalidInputException{
		// TODO 自动生成的方法存根
		if(version==null){
			throw new VersionNotSelectedException();
		}	
		EMDaoImpl emDaoImpl=new EMDaoImpl();
		try {
			try {
				em = emDaoImpl.getByProj_idAndVersion_idAndType(version.getProj_id(), version.getId(),0);
				if(isCbEnabled()){
					em.setRELY(getEmValue(1, cbRELY.getSelectionIndex()));
					em.setDOCU(getEmValue(2, cbDOCU.getSelectionIndex()));
					em.setSTOR(getEmValue(3, cbSTOR.getSelectionIndex()));
					em.setACAP(getEmValue(4, cbACAP.getSelectionIndex()));
					em.setPCAP(getEmValue(5, cbPCAP.getSelectionIndex()));
					em.setPLEX(getEmValue(6, cbPLEX.getSelectionIndex()));
					em.setTOOL(getEmValue(7, cbTOOL.getSelectionIndex()));
					em.setCPLX(getEmValue(8, cbCPLX.getSelectionIndex()));
					em.setTIME(getEmValue(9, cbTIME.getSelectionIndex()));
					em.setPVOL(getEmValue(10, cbPVOL.getSelectionIndex()));
					em.setPCON(getEmValue(11, cbPCON.getSelectionIndex()));
					em.setAPEX(getEmValue(12, cbAPEX.getSelectionIndex()));
					em.setLTEX(getEmValue(13, cbLTEX.getSelectionIndex()));
					em.setSITE(getEmValue(14, cbSITE.getSelectionIndex()));
					em.setSCED(getEmValue(15, cbSCED.getSelectionIndex()));
					em.setInputEm(0.0f);;
				}
				else {
					em.setRELY(0);
					em.setDOCU(0);
					em.setSTOR(0);
					em.setDOCU(0);
					em.setPCAP(0);
					em.setPLEX(0);
					em.setTOOL(0);
					em.setCPLX(0);
					em.setTIME(0);
					em.setPVOL(0);
					em.setPCON(0);
					em.setAPEX(0);
					em.setLTEX(0);
					em.setSITE(0);
					em.setSCED(0);
					em.setInputEm(Float.parseFloat(textEM.getText()));;
				}
				emDaoImpl.Update(em);
			} catch (EmNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
				em = new EM();
				em.setProj_id(version.getProj_id());
				em.setVersion_id(version.getId());
				em.setType(0);
				if(isCbEnabled()){
					em.setRELY(getEmValue(1, cbRELY.getSelectionIndex()));
					em.setDOCU(getEmValue(2, cbDOCU.getSelectionIndex()));
					em.setSTOR(getEmValue(3, cbSTOR.getSelectionIndex()));
					em.setACAP(getEmValue(4, cbACAP.getSelectionIndex()));
					em.setPCAP(getEmValue(5, cbPCAP.getSelectionIndex()));
					em.setPLEX(getEmValue(6, cbPLEX.getSelectionIndex()));
					em.setTOOL(getEmValue(7, cbTOOL.getSelectionIndex()));
					em.setCPLX(getEmValue(8, cbCPLX.getSelectionIndex()));
					em.setTIME(getEmValue(9, cbTIME.getSelectionIndex()));
					em.setPVOL(getEmValue(10, cbPVOL.getSelectionIndex()));
					em.setPCON(getEmValue(11, cbPCON.getSelectionIndex()));
					em.setAPEX(getEmValue(12, cbAPEX.getSelectionIndex()));
					em.setLTEX(getEmValue(13, cbLTEX.getSelectionIndex()));
					em.setSITE(getEmValue(14, cbSITE.getSelectionIndex()));
					em.setSCED(getEmValue(14, cbSCED.getSelectionIndex()));
					em.setInputEm(0.0f);
				}
				else {
					em.setRELY(0);
					em.setDOCU(0);
					em.setSTOR(0);
					em.setDOCU(0);
					em.setPCAP(0);
					em.setPLEX(0);
					em.setTOOL(0);
					em.setCPLX(0);
					em.setTIME(0);
					em.setPVOL(0);
					em.setPCON(0);
					em.setAPEX(0);
					em.setLTEX(0);
					em.setSITE(0);
					em.setSCED(0);
					em.setInputEm(Float.parseFloat(textEM.getText()));
				}
				emDaoImpl.Save(em);
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception	
				System.out.println("存在数据输入格式不正确");
				throw new InvalidInputException();
		} catch (EmMissingParamException e) {
			// TODO: handle exception
			throw new EmMissingParamException();
		}
	}
	
	public float getEmValue (int type,int index)throws EmMissingParamException{
		try {
			return alist.get(type-1)[index];
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			if(isCbEnabled())
			throw new EmMissingParamException();
			else {
				return 0.0f;
			}
		}	
		
	}
	
	public int getEmIndex(int type,float value){
		for(int i=0;i<alist.get(type-1).length;i++)
		{	
			if(value == alist.get(type-1)[i])
				return i;
		}
		return -1;
	}
	
	public boolean isCbEnabled(){
		Boolean enable;
		if(textEM.getText().equals(""))
		{	
			enable=true;
		}else {
			enable=false;
		}
		cbRELY.setEnabled(enable);
		cbDOCU.setEnabled(enable);
		cbSTOR.setEnabled(enable);
		cbACAP.setEnabled(enable);
		cbPCAP.setEnabled(enable);
		cbPLEX.setEnabled(enable);
		cbTOOL.setEnabled(enable);
		cbCPLX.setEnabled(enable);
		cbTIME.setEnabled(enable);
		cbPVOL.setEnabled(enable);
		cbPCON.setEnabled(enable);
		cbAPEX.setEnabled(enable);
	    cbLTEX.setEnabled(enable);
        cbSITE.setEnabled(enable);
        cbSCED.setEnabled(enable);
        return enable;
	}
	
	private void initLayot() {
		// TODO 自动生成的方法存根
		Label lblCalByPiont = new Label(this, SWT.NONE);
		FormData lblCalByPiont_fd = new FormData();
		lblCalByPiont_fd.top = new FormAttachment(2, 1);
		lblCalByPiont_fd.left = new FormAttachment(0,6);
		lblCalByPiont_fd.bottom = new FormAttachment(10, -1);
		lblCalByPiont.setLayoutData(lblCalByPiont_fd);
		lblCalByPiont.setText("参数估算");
		
		lblhorizontal = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData lblhorizontal_fd = new FormData();
		lblhorizontal_fd.bottom = new FormAttachment(10,-1);
		lblhorizontal_fd.top = new FormAttachment(2,1);
		lblhorizontal_fd.left = new FormAttachment(lblCalByPiont,1);
		lblhorizontal_fd.right = new FormAttachment(95, -5);
		lblhorizontal.setLayoutData(lblhorizontal_fd);
		
		Composite composite = new Composite(this, SWT.NONE);
		GridLayout cpgridLayout = new GridLayout();
		cpgridLayout.marginHeight = 0;
		cpgridLayout.marginWidth = 0;
		composite.setLayout(cpgridLayout);
		FormData cp_fd = new FormData();
		cp_fd.top = new FormAttachment( 10, 10);
		cp_fd.left = new FormAttachment(10, 10);
		cp_fd.bottom = new FormAttachment(80,-5);
		cp_fd.right = new FormAttachment(30, -2);
		composite.setLayoutData(cp_fd);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLayoutData(new FormData());
		GridLayout cp_1gridLayout = new GridLayout();
		cp_1gridLayout.marginHeight = 0;
		cp_1gridLayout.marginWidth = 0;
		composite_1.setLayout(cp_1gridLayout);
		FormData cp_1_fd = new FormData();
		cp_1_fd.top = new FormAttachment( 10, 10);
		cp_1_fd.left = new FormAttachment(composite,0);
		cp_1_fd.bottom = new FormAttachment(80,-5);
		cp_1_fd.right = new FormAttachment(50, -2);
		composite_1.setLayoutData(cp_1_fd);
		
		Composite composite_2 = new Composite(this, SWT.NONE);
		composite_2.setLayoutData(new FormData());
		GridLayout cp_2gridLayout = new GridLayout();
		cp_2gridLayout.marginHeight = 0;
		cp_2gridLayout.marginWidth = 0;
		composite_2.setLayout(cp_2gridLayout);
		FormData cp_2_fd = new FormData();
		cp_2_fd.top = new FormAttachment( 10, 5);
		cp_2_fd.left = new FormAttachment(composite_1, 15);
		cp_2_fd.bottom = new FormAttachment(72,-5);
		cp_2_fd.right = new FormAttachment(70, -2);
		composite_2.setLayoutData(cp_2_fd);
		
		Composite composite_3 = new Composite(this, SWT.NONE);
		composite_3.setLayoutData(new FormData());
		GridLayout cp_3gridLayout = new GridLayout();
		cp_3gridLayout.marginHeight = 0;
		cp_3gridLayout.marginWidth = 0;
		composite_3.setLayout(cp_3gridLayout);
		FormData cp_3_fd = new FormData();
		cp_3_fd.left = new FormAttachment(composite_2, 0);
		cp_3_fd.right = new FormAttachment(90, -10);
		cp_3_fd.top = new FormAttachment(10, 10);
		cp_3_fd.bottom = new FormAttachment(72,-5);
		composite_3.setLayoutData(cp_3_fd);
		
		
		Label lblRELY = new Label(composite, SWT.PUSH);
		lblRELY.setText("软件可靠性");
		lblRELY.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbRELY = new Combo(composite_1, SWT.PUSH);
		cbRELY.setToolTipText("");
		cbRELY.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbRELY.add("very low(slight inconvenience)",0 );
		cbRELY.add("low(easily recoverable)", 1);
		cbRELY.add("nominal(moderate easily)",2 );
		cbRELY.add("high(high financial loss)", 3);
		cbRELY.add("very high(risk to human life)",4 );
		
		Label lblDOCU = new Label(composite, SWT.PUSH);
		lblDOCU.setText("文档编制");
		lblDOCU.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbDOCU = new Combo(composite_1, SWT.PUSH);
		cbDOCU.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbDOCU.add("very low",0);
		cbDOCU.add("low",1);
		cbDOCU.add("nominal",2);
		cbDOCU.add("high",3);
		cbDOCU.add("wery high",4);
		
		Label lblSTOR = new Label(composite, SWT.PUSH);
		lblSTOR.setText("主存储约束");
		lblSTOR.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbSTOR = new Combo(composite_1, SWT.PUSH);
		cbSTOR.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbSTOR.add("nominal(50% use of available)",0);
		cbSTOR.add("high(70% use of available)",1);
		cbSTOR.add("very high(85% use of available)",2);
		cbSTOR.add("extra high(95% use of available)",3);
		
		Label lblACAP = new Label(composite, SWT.PUSH);
		lblACAP.setText("分析员能力");
		lblACAP.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbACAP = new Combo(composite_1, SWT.PUSH);
		cbACAP.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbACAP.add("very low(15th percentile)",0 );
		cbACAP.add("low(35th percentile)",1 );
		cbACAP.add("nominal(55th percentile)",2 );
		cbACAP.add("high(75th percentile)", 3);
		cbACAP.add("very high(90th percentile)",4 );
		
		Label lblPCAP = new Label(composite, SWT.PUSH);
		lblPCAP.setText("程序员能力");
		lblPCAP.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPCAP = new Combo(composite_1, SWT.PUSH);
		cbPCAP.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPCAP.add("very low(15th percentile)",0 );
		cbPCAP.add("low(35th percentile)",1 );
		cbPCAP.add("nominal(55th percentile)",2 );
		cbPCAP.add("high(75th percentile)", 3);
		cbPCAP.add("very high(90th percentile)",4 );
		
		Label lblPLEX = new Label(composite, SWT.PUSH);
		lblPLEX.setText("平台经验");
		lblPLEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPLEX = new Combo(composite_1, SWT.PUSH);
		cbPLEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPLEX.add("very low(<=2 months)",0 );
		cbPLEX.add("low(2~6 months)",1 );
		cbPLEX.add("nominal(6 months~1 years)",2 );
		cbPLEX.add("high(1~3years)", 3);
		cbPLEX.add("very high(>=6 years)",4 );
		
		Label lblTOOL = new Label(composite, SWT.PUSH);
		lblTOOL.setText("软件工具使用");
		lblTOOL.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbTOOL = new Combo(composite_1, SWT.PUSH);
		cbTOOL.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbTOOL.add("very low(edit,code,debug)",0);
		cbTOOL.add("low(simple backend CASE,little integration)", 1);
		cbTOOL.add("nominal(basic lifecycle tools)",2);
		cbTOOL.add("high(strong mature lifecycle tools)", 3);
		cbTOOL.add("very high(proactive mature lifecycle tools)", 4);
		
		Label lblCPLX = new Label(composite_2, SWT.PUSH);
		lblCPLX.setText("产品复杂性");
		lblCPLX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbCPLX = new Combo(composite_3, SWT.PUSH);
		cbCPLX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbCPLX.add("very low",0);
		cbCPLX.add("low", 1);
		cbCPLX.add("nominal",2);
		cbCPLX.add("high", 3);
		cbCPLX.add("very high", 4);
		cbCPLX.add("extra high",5);
		
		Label lblTIME = new Label(composite_2, SWT.PUSH);
		lblTIME.setText("执行时间约束");
		lblTIME.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbTIME = new Combo(composite_3, SWT.PUSH);
		cbTIME.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbTIME.add("nominal(< 50% use of available execution time)",0);
		cbTIME.add("high(70% use of available execution time)",1);
		cbTIME.add("very high(85% use of available execution time)",2);
		cbTIME.add("extra high(95% use of available execution time)",3);
		
		Label lblPVOL = new Label(composite_2, SWT.PUSH);
		lblPVOL.setText("平台易变性");
		lblPVOL.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPVOL = new Combo(composite_3, SWT.PUSH);
		cbPVOL.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPVOL.add("low(Major change every 12 months; Minor change every 1 month)",0);
		cbPVOL.add("nominal(Major change every 6 months; Minor change every 2 weaks)",1);
		cbPVOL.add("high(Major change every 2 months; Minor change every 1 weak)",2);
		cbPVOL.add("very high(Major change every 2 months; Minor change every 2days)",3);
		
		Label lblPCON = new Label(composite_2, SWT.PUSH);
		lblPCON.setText("人员连续性");
		lblPCON.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPCON = new Combo(composite_3, SWT.PUSH);
		cbPCON.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbPCON.add("very low(48%/a year)",0);
		cbPCON.add("low(24%/a year)", 1);
		cbPCON.add("nominal(12%/a year)",2);
		cbPCON.add("high(6%/a year)", 3);
		cbPCON.add("very high(3%/a year)", 4);
		
		Label lblAPEX = new Label(composite_2, SWT.PUSH);
		lblAPEX.setText("应用经验");
		lblAPEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbAPEX = new Combo(composite_3, SWT.PUSH);
		cbAPEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbAPEX.add("very low(<=2 months)",0);
		cbAPEX.add("low(2~6 months)", 1);
		cbAPEX.add("nominal(6months ~1 years)",2);
		cbAPEX.add("high(1~3years)", 3);
		cbAPEX.add("very high(<=6 years)", 4);
		
		Label lblLTEX = new Label(composite_2, SWT.PUSH);
		lblLTEX.setText("语言和工具经验");
		lblLTEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbLTEX = new Combo(composite_3, SWT.PUSH);
		cbLTEX.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbLTEX.add("very low(<=2 months)",0);
		cbLTEX.add("low(2~6 months)", 1);
		cbLTEX.add("nominal(6months ~1 years)",2);
		cbLTEX.add("high(1~3years)", 3);
		cbLTEX.add("very high(<=6 years)", 4);
		
		//这里选择了site的分布描述
		Label lblSITE = new Label(composite_2, SWT.PUSH);
		lblSITE.setText("多点开发");
		lblSITE.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbSITE = new Combo(composite_3, SWT.PUSH);
		cbSITE.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbSITE.add("very low(international)",0);
		cbSITE.add("low(Multi-city and MUlticompany)", 1);
		cbSITE.add("nominal(Multi-city or Multicompany)",2);
		cbSITE.add("high(Same city or metro area)", 3);
		cbSITE.add("very high(Same building or complex)", 4);
		cbSITE.add("extra high(fully collocated)", 5);
		
		Label lblSCED = new Label(composite, SWT.PUSH);
		lblSCED.setText("发展计划");
		lblSCED.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbSCED = new Combo(composite_1, SWT.PUSH);
		cbSCED.setLayoutData(new GridData(GridData.FILL_BOTH));
		cbSCED.add("very low(75% of nominal)",0);
		cbSCED.add("low(85% of nominal)", 1);
		cbSCED.add("nominal(100% of nominal)",2);
		cbSCED.add("high(130% of nominal)", 3);
		cbSCED.add("very high(160% of nominal)", 4);
		
		Label lblEnterE = new Label(this, SWT.NONE);
		FormData lblEnterE_fd = new FormData();
		lblEnterE_fd.top = new FormAttachment(composite, 10);
		lblEnterE_fd.left = new FormAttachment(0,6);
		lblEnterE_fd.bottom = new FormAttachment(92, -6);
		lblEnterE.setLayoutData(lblEnterE_fd);
		lblEnterE.setText("直接输入");
		
		lblhorizontal1 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(85,-1);
		fd_label.top = new FormAttachment(82,1);
		fd_label.left = new FormAttachment(lblEnterE,1);
		fd_label.right = new FormAttachment(95, -5);
		lblhorizontal1.setLayoutData(fd_label);
		
		
		Label lblEM = new Label(this, SWT.NONE);
		FormData fd_lblEM = new FormData();
		fd_lblEM.left = new FormAttachment(10,10);
		fd_lblEM.top = new FormAttachment(lblhorizontal1, 10);
		lblEM.setLayoutData(fd_lblEM);
		lblEM.setText("EM");
		
		textEM = new Text(this, SWT.BORDER);
		textEM.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				isCbEnabled();
			}
		});
		FormData fd_textEM = new FormData();
		fd_textEM.left =new FormAttachment(lblEM,30);
		fd_textEM.top = new FormAttachment(lblhorizontal1, 10);
		textEM.setLayoutData(fd_textEM);
		
		Button btn_save = new Button(this, SWT.NONE);
		btn_save.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					save();
					System.out.println("保存成功");
				} catch (EmMissingParamException e) {
					// TODO 自动生成的 catch 块
					System.out.println("缺少参数");
					System.out.println("保存失败");
					e.printStackTrace();
				} catch (VersionNotSelectedException e) {
					// TODO 自动生成的 catch 块
					System.out.println("未选择版本");
					System.out.println("保存失败");
					e.printStackTrace();
				} catch (InvalidInputException e) {
					// TODO 自动生成的 catch 块
					System.out.println("输入不正确");
					System.out.println("保存失败");
					e.printStackTrace();
				}
			}
		});
		FormData fd_btn_save = new FormData();
		fd_btn_save.top = new FormAttachment(lblhorizontal1, 10);
		fd_btn_save.right = new FormAttachment(composite_3, 0, SWT.RIGHT);
		btn_save.setLayoutData(fd_btn_save);
		btn_save.setText("Save");
		
		
		String sReturn = System.getProperty("line.separator");
		lblRELY.setToolTipText("RELY (Reliability)） is the measure "
				+ sReturn +"of the extent to which the software "
				+sReturn + "must perform its intended function "
				+ sReturn +"over a period of time. If the effect"
				+ sReturn +"of a software failure is only slight"
				+ sReturn +"inconvenience then RELY is very low."
				+ sReturn +"If a failure would risk human life "
				+ sReturn +"then RELY is very high.");
		lblCPLX.setToolTipText("CPLX (Product Complexity) is divided"
				+ sReturn +"into five areas: control operations,"
				+sReturn + "computational operations, device-"
				+ sReturn +"dependent operations, data management"
				+ sReturn +"operations, and user interface "
				+ sReturn +"management operations. Select the "
				+ sReturn +"area or combination of areas that "
				+ sReturn +"characterize the product or a "
				+ sReturn +"sub-system of the product. The  "
				+ sReturn +"complexity rating is the subjective "
				+ sReturn +"weighted average of these areas. ");
		lblTIME.setToolTipText("TIME (Execution Time Constraint) is a"
				+ sReturn +"measure of the execution time "
				+sReturn + "constraint imposed upon a software"
				+ sReturn +"system. The rating is expressed in "
				+ sReturn +"terms of the percentage of available"
				+ sReturn +"execution time expected to be used by"
				+ sReturn +"the system or subsystem consuming the"
				+ sReturn +"execution time resource.");
		lblPVOL.setToolTipText("PVOL(Platform Volatility) is used "
				+ sReturn +"here to mean the complex of hardware"
				+ sReturn +"and software");
		lblPCON.setToolTipText("The rating scale for PCON (Personnel"
				+ sReturn +"Continuity) is in terms of the "
				+sReturn + "constraint imposed upon a software"
				+ sReturn +"project’s annual personnel turnover:"
				+ sReturn +"from 3%, very high continuity, to"
				+ sReturn +"48%, very low continuity");
		lblAPEX.setToolTipText("The rating for APEX (Applications "
				+ sReturn +"Experience ,formerly labeled AEXP) is"
				+sReturn + "dependent on the level of "
				+ sReturn +"applications experience of the"
				+ sReturn +"project team developing the software"
				+ sReturn +"system or subsystem. A very low  "
				+ sReturn +"rating is for application experience "
				+ sReturn +"of less than 2 months. A very high "
				+ sReturn +"rating is for experience of 6 years"
				+ sReturn +"or more");
		lblLTEX.setToolTipText("LTEX is a measure of the level of "
				+ sReturn +"programming language and software "
				+sReturn + "tool experience of the project team "
				+ sReturn +"developing the software system or "
				+ sReturn +"subsystem. Software development "
				+ sReturn +"includes the use of tools that "
				+ sReturn +"perform requirements and design "
				+ sReturn +"representation and analysis, "
				+ sReturn +"configuration management, document "
				+ sReturn +"extraction, library management,"
				+ sReturn +"program style and formatting, "
				+ sReturn +"consistency checking, planning and "
				+ sReturn +"control, etc.");
		lblSITE.setToolTipText("Multisite Development (SITE) "
				+ sReturn +"determining its cost driver rating "
				+sReturn + "involves the assessment and"
				+ sReturn +"judgement-based averaging of two"
				+ sReturn +"factors: site collocation (from fully"
				+ sReturn +"collocated to international "
				+ sReturn +"distribution) and communication"
				+ sReturn +"support (from surface mail and some "
				+ sReturn +"phone access to full interactive "
				+ sReturn +"multimedia).");
		lblDOCU.setToolTipText("The rating scale for the DOCU  "
				+ sReturn +"(Documentation) cost driver is "
				+sReturn + "evaluated in terms of the suitability "
				+ sReturn +"of the project’s documentation to "
				+ sReturn +"its life-cycle needs. The rating "
				+ sReturn +"scale goes from Very Low(many life-"
				+ sReturn +"cycle needs uncovered) to Very High "
				+ sReturn +"(very excessive for life-cycle "
				+ sReturn +"needs)Attempting to save costs via "
				+ sReturn +"Very Low or Low documentation levels "
				+ sReturn +"will generally incur extra costs "
				+ sReturn +"during the maintenance portion of the"
				+ sReturn +"life-cycle. Poor or missing"
				+ sReturn +"documentation will increase the "
				+ sReturn +"Software Understanding (SU) "
				+ sReturn +"increment.");
		lblSTOR.setToolTipText("STOR rating represents the degree of"
				+ sReturn +"main storage constraint imposed on a"
				+sReturn + "software system or subsystem. Given"
				+ sReturn +"the remarkable increase in available "
				+ sReturn +"processor execution time and main "
				+ sReturn +"storage, one can question whether "
				+ sReturn +"these constraint variables are still"
				+ sReturn +"relevant. However ,many applications"
				+ sReturn +"continue to expand to consume  "
				+ sReturn +"whatever resources are available---"
				+ sReturn +"particularly with large and growing "
				+ sReturn +"COTS products---making these cost "
				+ sReturn +"drivers still relevant. The rating "
				+ sReturn +"ranges from nominal (less than 50%), "
				+ sReturn +"to extra high (95%).");
		lblACAP .setToolTipText("Analysts are personnel who work on "
				+ sReturn +"requirements, high-level design and "
				+sReturn + "detailed design. The major attributes"
				+ sReturn +"that should be considered in this  "
				+ sReturn +"rating are analysis and design  "
				+ sReturn +"ability, efficiency and thoroughness "
				+ sReturn +"and the ability to communicate and "
				+ sReturn +"cooperate. The rating should not"
				+ sReturn +"consider the level of experience of  "
				+ sReturn +"the analyst; that is rated with APEX"
				+ sReturn +"LTEX, and PLEX. Analyst teams that "
				+ sReturn +"fall in the fifteenth percentile are"
				+ sReturn +"rated very low and those that fall in"
				+ sReturn +"the ninetieth percentile are rated as"
				+ sReturn +"very high.");
		lblPCAP .setToolTipText("Evaluation should be based on the "
				+ sReturn +"capability of the programmers as a "
				+sReturn + "team rather than as individuals. "
				+ sReturn +"Major factors which should be  "
				+ sReturn +"considered in the rating are ability,"
				+ sReturn +"efficiency and thoroughness, and the "
				+ sReturn +"ability to communicate and cooperate."
				+ sReturn +"The experience of the programmer "
				+ sReturn +"should not be considered here; it is"
				+ sReturn +"rated with APEX, LTEX, and PLEX. A "
				+ sReturn +"very low rated programmer team is in "
				+ sReturn +"the fifteenth percentile and a very "
				+ sReturn +"high rated programmer team is in the"
				+ sReturn +"ninetieth percentile.");
		lblPLEX .setToolTipText("The Post-Architecture model broadens"
				+ sReturn +"the productivity influence of "
				+sReturn + "platform experience, PLEX (formerly "
				+ sReturn +"labeled PEXP), by recognizing the "
				+ sReturn +"importance of understanding the use "
				+ sReturn +"of more powerful platforms, including"
				+ sReturn +"more graphic user interface, "
				+ sReturn +"database, networking, and distributed "
				+ sReturn +"middleware capabilities");
		lblTOOL .setToolTipText("The tool rating ranges from simple "
				+ sReturn +"edit and code, very low, to "
				+sReturn + "integrated life-cycle management "
				+ sReturn +"tools, very high. An emerging "
				+ sReturn +"extension of COCOMO II is in the "
				+ sReturn +"process of elaborating the TOOL "
				+ sReturn +"rating scale and breaking out the "
				+ sReturn +"effects of TOOL capability, maturity, "
				+ sReturn +"and integration");
		lblSCED .setToolTipText("This rating measures the schedule "
				+ sReturn +"constraint imposed on the project "
				+ sReturn + "team developing the software. The "
				+ sReturn +"ratings are defined in terms of the "
				+ sReturn +"percentage of schedule stretch-out or"
				+ sReturn +"acceleration with respect to a "
				+ sReturn +"nominal schedule for a project "
				+ sReturn +"requiring a given amount of "
				+ sReturn +"effort.Accelerated schedules tend to "
				+ sReturn + "produce more effort in the earlier"
				+ sReturn +"phases to eliminate risks andrefine "
				+ sReturn +"the architecture, more effort in the"
				+ sReturn +"later phases to accomplish more "
				+ sReturn +"testing anddocumentation in parallel"
				+ sReturn +"Schedule compression of 75% is rated "
				+ sReturn +"very low. A schedule stretch-out of "
				+ sReturn +"160% is rated very high. Stretch-outs"
				+ sReturn +"do not add or decrease effort.Their "
				+ sReturn +"savings because of smaller team size"
				+ sReturn +"are generally balanced by the need to "
				+ sReturn + "carry projectadministrative functions"
				+ sReturn +"over a longer period of time. SCED is"
				+ sReturn +"the only cost driver that is used to"
				+ sReturn +"describe the effect of schedule "
				+ sReturn +"compression /expansion for the whole"
				+ sReturn +"project. The scale factors are also "
				+ sReturn +"used to describe the whole "
				+ sReturn +"project.All of the other cost drivers"
				+ sReturn +"are used to describe each module in a"
				+ sReturn +"multiple module project.");
		
	}
}
