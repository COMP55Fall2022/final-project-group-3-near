package edu.pacific.comp55.ProjectCode;

import java.util.*;

public class Board {
	// private int numRows;  *Rows are always 20
	// private int numCols;  *Cols are always 10
	
	//Block[] list; made a list instead like a vector to input easier
	private ArrayList<Block>blocksOnBoard = new ArrayList<Block>();
	
	private Block[][] board;
	
	private Block activeBlock;
	private Block nextBlock;
	private Block tempBlock;
	
	public Board() {
		board = new Block[20][10];
	}
	
	public Block createNextBlock(Orientation orientation, boolean rock, boolean cantRotatePhase, int startRow, int startCol) {
		nextBlock = new Block(orientation, rock, cantRotatePhase, startRow, startCol);
		return nextBlock;
	}
	
	public void spawnBlock(){
		activeBlock = nextBlock;
		nextBlock = new Block(Orientation.UP, false, false, 0,0);
		if (activeBlock.type == BlockType.BAR) {
			activeBlock.setStartSpace(0,4);
		}
		else if(activeBlock.type == BlockType.LEFTL){
			activeBlock.setStartSpace(1, 3);
		}
		else if (activeBlock.type == BlockType.RIGHTL) {
			activeBlock.setStartSpace(1,5);
		}
		else if (activeBlock.type == BlockType.LEFTS) {
			activeBlock.setStartSpace(0, 4);
		}
		else if (activeBlock.type == BlockType.RIGHTS) {
			activeBlock.setStartSpace(0, 4);
		}
		else if (activeBlock.type == BlockType.SQUARE) {
			activeBlock.setStartSpace(1, 4);
		}
		else { // T block
			activeBlock.setStartSpace(1,4);
		}
		
		System.out.println(activeBlock);
		
		Space[] spaces = new Space[4];
		spaces = activeBlock.spacesOccupied();
		for (int i = 0; i < 4; i++) {
			board[spaces[i].getRow()][spaces[i].getCol()] = activeBlock;
		}
		//TODO 
	}
	
	public Block getBlock(Space s) {
		//nora: this function will be the equivalent of getVehicle in trafficjam, takes a space and returns whether there's a block there or not
		return board[s.getRow()][s.getCol()];
	}
	
	public boolean canPlaceBlock() {
		return false; // TODO
	}
	
	public boolean canClearLine() {
		return false; // TODO
	}
	
	public boolean canRotate() {
		System.out.println("canRotate function run.");
		if(!activeBlock.canRotateType()) {
			return false;
		}
		return false; // nora: ill do the rest of this after we're ready to do the rotation function.
	}
	
	public boolean canHold() {
		return false; // TODO
		// ralph: you can only switch out the active block with the currently held block ONCE, you cannot infinitely switch blocks back and forth until the active block is placed
	}
	
	public void addBlock(Block addMe) {
		//add addMe to board and arraylist
	}//nora
	
	public void removeBlock() {
		tempBlock = activeBlock;
		//need to remove it from the board/grid
		
		//need to remove it from the array
		
	}//nora
	
	//this will check the spaces occupied against the spaces if I move some direction, and see if the space is otherwise occupied by some block on the board
	public boolean moveActiveBlockDown() {
		//check if it can move considering the bounds of the board
		if(!activeBlock.canMoveDown()) {
			return false;
		}
		Space[] spacesOccupied = activeBlock.spacesOccupied();
		for(int i = 0; i<spacesOccupied.length; i++) {
			//check (using temporary array) if it can move considering other blocks on the board
			spacesOccupied[i].setRow(spacesOccupied[i].getRow()-1);
			if(getBlock(spacesOccupied[i]) != null) {
				return false;
			}
		}
		removeBlock();
		//now move it!
		activeBlock = new Block(activeBlock.getOrientation(), activeBlock.isRock(), activeBlock.getCantRotatePhase(), activeBlock.getStartSpace().getRow()-1, activeBlock.getStartSpace().getCol());
		addBlock(activeBlock);
		return true; // nora
	}
	
	public boolean moveActiveBlockLeft() {
		return false; // nora
	}
	
	public boolean moveActiveBlockRight() {
		return false; // nora
	}
	
	public void blockPlaced() {//nora: this should be run when a block reaches where it should be placed on the board
		//adds the block's spaces occupied to the board's spaces occupied, to make line deletion easier.
		//only 2 blocks should exist in board, activeBlock and nextBlock. and maybe the held block
		//everything else on the board is just occupied spaces.
		
	}
	
	public String toString() {
		return BoardConverter.createString(this);
	}
	
	// Board Testing
	public static void main(String[] args) {
		Board b = new Board();
		b.createNextBlock(Orientation.UP, false, false, 0,0);
		b.spawnBlock();
		System.out.println(b);
	}
}
