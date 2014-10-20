package com.virt.Service;

import com.virt.Model.AssignVMModel;

public class UpdateUsage {
int usageAmt=0;
	AssignVMModel asVMMod=new AssignVMModel();
	VMAssignService vmaServ=new VMAssignService();
	
	
	public void UpdateDetail()
	{
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
				try {
					
					usageAmt=usageAmt+10;
					asVMMod.setUsage(Integer.toString(usageAmt));
					vmaServ.Update(asVMMod);
					Thread.sleep(100000);;
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
					
					
				}
				
				
			}
		});

	}
}


