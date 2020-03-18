package day_24;

import java.util.Scanner;
import java.util.Random;

public class sokoban {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int game[][] = new int[7][7];
		int wall_count = 0;		int ball_count = 0;		int goalpoast_count = 0;
		int player_x = 0;		int player_y = 0;
		int ball_x = 0;			int ball_y = 0;
		
		while(wall_count < 4)
		{
			int wall1 = ran.nextInt(7);
			int wall2 = ran.nextInt(7);
			
			if(game[wall1][wall2] == 0)
			{
				game[wall1][wall2] = 6;
				wall_count++;
			}
		}
		
		while(ball_count < 1)
		{
			int ball1 = ran.nextInt(7);
			int ball2 = ran.nextInt(7);
			
			if(game[ball1][ball2] == 0)
			{
				game[ball1][ball2] = 7;
				ball_count++;
			}
		}
		
		while(goalpoast_count < 1)
		{
			int goalpoast1 = ran.nextInt(7);
			int goalpoast2 = ran.nextInt(7);
			
			if(game[goalpoast1][goalpoast2] == 0)
			{
				game[goalpoast1][goalpoast2] = 8;
				goalpoast_count++;
			}
		}
		
		System.out.println("        ====SOKOBAN====");				//show Bingo Board
		for (int i = 0; i < 7; i++) 
		{
			for (int j = 0; j < 7; j++) 
			{	
				if(game[i][j] == 6)
				{
					System.out.print("[벽 ] ");
				}
				else if(game[i][j] == 7)
				{
					System.out.print("[공 ] ");
				}
				else if(game[i][j] == 8)
				{
					System.out.print("[골 ] ");
				}
				else if(game[i][j] == 9)
				{
					System.out.print("[W ] ");
				}
				else
				{
					System.out.print("["+game[i][j] + " ] ");
				}
			}
			System.out.println();
		}
		
		System.out.println("게임 시작!");
		System.out.println("캐릭터의 시작 위치를 입력해주세요");
		System.out.println("캐릭터의 x좌표");
		int p1x = sc.nextInt();
		System.out.println("캐릭터의 y좌표");
		int p1y = sc.nextInt();
		
		if(game[p1y][p1x] == 0)				//캐릭터 움직이게 하는 if문
		{
			game[p1y][p1x] = 9;
			player_x = p1x;
			player_y = p1y;
		}
		
		while(true)
		{	
			int check = 0;
			
			System.out.println("        ====SOKOBAN====");				//show Bingo Board
			for (int i = 0; i < 7; i++) 
			{
				for (int j = 0; j < 7; j++) 
				{	
					if(game[i][j] == 6)
					{
						System.out.print("[벽 ] ");
					}
					else if(game[i][j] == 7)
					{
						System.out.print("[공 ] ");
						ball_x = j;
						ball_y = i;
					}
					else if(game[i][j] == 8)
					{
						System.out.print("[골 ] ");
					}
					else if(game[i][j] == 9)
					{
						System.out.print("[W ] ");
					}
					else if(game[i][j] == 0)
					{
						System.out.print("["+game[i][j] + " ] ");
					}
				}
				System.out.println();
			}
			
			System.out.println("[1]상 [2]하 [3]좌 [4]우");
			int dir = sc.nextInt();
			
			if(dir == 1) {					//상
				if(player_y == 0)
				{
					game[0][player_x] = game[0][player_x];
					check = 1;
				}
				else
				{	
					if(game[player_y-1][player_x] == 6)
					{
						System.out.println("벽을 만나 움직을수 없습니다.");
					}
					else
					{
						if(game[player_y-1][player_x] == 7)
						{
							if(ball_y==0)
							{
								game[0][ball_x] = game[0][ball_x];
								check = 1;
							}
							else
							{
								game[ball_y-1][ball_x] = 7;
								game[ball_y][ball_x] = 0;
								ball_y = ball_y-1;
							}
						}
						
						game[player_y-1][player_x] = 9;
						game[player_y][player_x] = 0;
						player_y = player_y-1;
					}
					
				}
				
				
				if(check == 1)
				{
					System.out.println("[상]으로 움직일수 없습니다.");
				}
			}
			else if(dir == 2) {					//하
				if(player_y == 6)
				{
					game[6][player_x] = game[6][player_x];
					check = 1;
				}
				else
				{
					if(game[player_y+1][player_x] == 6)
					{
						System.out.println("벽을 만나 움직을수 없습니다.");
					}
					else
					{
						if(game[player_y+1][player_x] == 7)
						{
							if(ball_y==0)
							{
								game[0][ball_x] = game[0][ball_x];
								check = 1;
							}
							else
							{
								game[ball_y+1][ball_x] = 7;
								game[ball_y][ball_x] = 0;
								ball_y = ball_y+1;
							}
						}
						
						game[player_y+1][player_x] = 9;
						game[player_y][player_x] = 0;
						player_y = player_y+1;
					}
				}
				
				if(check == 1)
				{
					System.out.println("[하]로 움직일수 없습니다.");
				}
			}
			else if(dir == 3) {					//좌
				if(player_x == 0)
				{
					game[player_y][0] = game[player_y][0];
					check = 1;
				}
				else
				{
					if(game[player_y][player_x-1] == 6)
					{
						System.out.println("벽을 만나 움직을수 없습니다.");
					}
					else
					{
						if(game[player_y][player_x-1] == 7)
						{
							if(ball_x==0)
							{
								game[0][ball_x] = game[0][ball_x-1];
								check = 1;
							}
							else
							{
								game[ball_y][ball_x-1] = 7;
								game[ball_y][ball_x] = 0;
								ball_x = ball_x-1;
							}
						}
						
						game[player_y][player_x-1] = 9;
						game[player_y][player_x] = 0;
						player_x = player_x-1;
					}
				}
				
				if(check == 1)
				{
					System.out.println("[좌]로 움직일수 없습니다.");
				}
			}
			else if(dir == 4) {					//우
				if(player_x == 6)
				{
					game[player_y][6] = game[player_y][6];
					check = 1;
				}
				else
				{
					if(game[player_y][player_x+1] == 6)
					{
						System.out.println("벽을 만나 움직을수 없습니다.");
					}
					else
					{
						if(game[player_y][player_x+1] == 7)
						{
							if(ball_x==6)
							{
								game[0][ball_x] = game[0][ball_x];
								check = 1;
							}
							else
							{
								game[ball_y][ball_x+1] = 7;
								game[ball_y][ball_x] = 0;
								ball_x = ball_x+1;
							}
						}
						
						game[player_y][player_x+1] = 9;
						game[player_y][player_x] = 0;
						player_x = player_x+1;
					}
				}
				
				if(check == 1)
				{
					System.out.println("[우]로 움직일수 없습니다.");
				}
			}
			else
			{
				System.out.println("이동키를 잘못 입력하였습니다.");
			}
			
		}//무한 반복 종료
		
	}
}
