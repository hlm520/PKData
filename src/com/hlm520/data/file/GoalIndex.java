package com.hlm520.data.file;

class GoalIndex {
	
	Index index ;
	public SetFilePath setGoal(Index index) {
		
		this.index = index;
		
		SetFilePath sfp = new SetFilePath();
		
		sfp.setIndex(index);
		
		return sfp;
	}
	
	protected Index getGoal() {
		
		return index;
		
	}

}
