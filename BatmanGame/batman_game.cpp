#include <bits/stdc++.h>
#include <windows.h>
#include <conio.h>
#include <cstdio>
using namespace std;

//宣告一個structure建立敵人資料
struct _Enemy{
	string Name;
	int Lv;	
};
typedef struct _Enemy enemy;

//宣告一個class定義遊戲
class Game{
public:	
	//初始化蝙蝠俠等級
	Game(){
		BatmanLv=5;
	}
	
	//初始化敵人資料
	enemy EnemyName(char ch){
		switch(ch){
			case 'H':
					E.Name="Harley Quinn";
					E.Lv=2;
					break;
			case 'R':
					E.Name="Riddler";
					E.Lv=3;
					break;
			case 'T':
					E.Name="Two Face";
					E.Lv=4;
					break;
			case 'P':
					E.Name="Penguin";
					E.Lv=6;
					break;
			case 'J':
					E.Name="Joker";
					E.Lv=15;
					break;
		}
		return E;
	}
	
	//定義蝙蝠俠技能
	string BatmanSkill(char n){
		string skill;
		switch(n){
			case '1':
					skill="Batman Kick !!";
					break;
			case '2':
					skill="Batman Punch !!";
					break;	
			case '3':
					skill="Bat Mobile !!";
					break;		
			case '4':
					skill="Batman Batarang !!";
					break;																							
		}
		return skill;
	}
	
	//顯示蝙蝠俠等級
	int BatmanLevel(){
		return BatmanLv;
	}
	
	//提升蝙蝠俠等級
	void BatmanLevelUP(int Lv){
		BatmanLv+=Lv;
		cout << "Batman's Level UP !!! Level: " << BatmanLv << endl;
	}

	//暫停遊戲並將畫面文字清除
	void Continue(){
		system("pause");
		system("cls");	
	}	
private:
	enemy E;
	int BatmanLv;
};

void Welcome(){
	string title[128]=
	{
		"  	       _,    _   _    ,_        \n",
		"      	  o888P      Y8o8Y      Y888o    \n",
		"	 d88888      88888      88888b 	\n",
		"	d888888b_  _d88888b_  _d888888b \n",
		"	8888888888888888888888888888888 \n",
		"	8888888888888888888888888888888 \n",
		"	YJGS8P Y888P Y888P Y888P Y8888P \n",
		"	 Y888   '8'   Y8P   '8'   888Y  \n",
		"	  '8o          V          o8'   \n"
			                         														
	};

	for(int i=0;i<64;i++){
			cout << title[i];
	}
	
	cout << "\n" << "\n" << "\n";
	cout << "         Press Enter to start the GAME.\n";	
	char temp;
	cin.get(temp);
	system("cls");		
}

//呼叫Windows API隱藏光標
void Hide()
{
	HANDLE hOut;
	CONSOLE_CURSOR_INFO curInfo;
	
	//定義hOut取得標準輸出
	hOut=GetStdHandle(STD_OUTPUT_HANDLE);
	//定義光標的大小
	curInfo.dwSize=1;
	//定義光標的可見性
	curInfo.bVisible=0;
	//設置視窗中的光標
	SetConsoleCursorInfo(hOut,&curInfo);		
}

//呼叫Windows API將視窗中的光標移至左上角
void Set(){
	HANDLE hOut;
	//定義光標位置到左上角
	COORD pos={0,0};
	hOut=GetStdHandle(STD_OUTPUT_HANDLE);
	SetConsoleCursorPosition(hOut,pos);
}

int main(){
	Hide();		
    char maze[64][64]=
	{
		"######################",
		"#B#  #  #   #   # T# #",
		"#       #  R  #   #  #",
		"#  # # #    #     #  #",
		"#    H     # P   #   #",
		"#    #       #     # #",
		"#  #    #  #    # #  #",
		"#     #       #  J   #",
		"################# ####"
    };	
	Welcome();
	
	Game game;
	enemy E;	
	char type;
	int x=1,y=1;
	string skill;
	char ch;
	for(int i=0;i<9;i++){
		puts(maze[i]);//顯示地圖
	}	
	while(1)
	{				
		ch=getch();
		switch(ch){
			case 's':case 'S':
					if(maze[x+1][y]==' '){
					 	maze[x][y]=' ';
					 	x++;
					 	maze[x][y]='B';
					}
					else if(maze[x+1][y]=='H'||maze[x+1][y]=='R'||maze[x+1][y]=='T'||maze[x+1][y]=='P'||maze[x+1][y]=='J'){
						E=game.EnemyName(maze[x+1][y]);
						cout << "Batman meets enemy: " << E.Name << "   Level: " << E.Lv << endl;
						if(game.BatmanLevel()<=E.Lv){
							cout << "Batman's Level: "<<game.BatmanLevel() << " is under than "<<E.Name <<"'s Level: "<< E.Lv << ",he can't beats " << E.Name <<"." << endl;
							game.Continue();
						}
						else{
							cout << "Key in number to use the skill: \n";
							cout << "1.Batman Kick  \n2.Batman Punch  \n3.Bat Mobile  \n4.Batman Batarang\n" << endl;
							cout << "Input : ";
							cin >> type;
							//避免輸入錯誤技能的防呆機制
							while(type!='1'&&type!='2'&&type!='3'&&type!='4'){
								cout << endl;
								cout << "Batman can't use that!!" << endl << endl;
								cout << "Key in number to use the skill: \n";
								cout << "1.Batman Kick  \n2.Batman Punch  \n3.Bat Mobile  \n4.Batman Batarang\n" << endl;
								cout << "Input : ";								
								cin >> type;
							}
							skill=game.BatmanSkill(type);
							cout << "Batman uses " << skill << " Beats the enemy " << E.Name << "!!!"<< endl;
							game.BatmanLevelUP(E.Lv);
						 	maze[x][y]=' ';
						 	x++;
						 	maze[x][y]='B';
							game.Continue();						 	
						}
					}
				    break;
			case 'w':case 'W':
					if(maze[x-1][y]==' '){
					 	maze[x][y]=' ';
					 	x--;
					 	maze[x][y]='B';
					}
					else if(maze[x-1][y]=='H'||maze[x-1][y]=='R'||maze[x-1][y]=='T'||maze[x-1][y]=='P'||maze[x-1][y]=='J'){
						E=game.EnemyName(maze[x-1][y]);
						cout << "Batman meets enemy: " << E.Name << "   Level: " << E.Lv << endl;
						if(game.BatmanLevel()<=E.Lv){
							cout << "Batman's Level: "<<game.BatmanLevel() << " is under than "<<E.Name <<"'s Level: "<< E.Lv << ",he can't beats " << E.Name <<"." << endl;
							game.Continue();
						}
						else{
							cout << "Key in number to use the skill: \n";
							cout << "1.Batman Kick  \n2.Batman Punch  \n3.Bat Mobile  \n4.Batman Batarang\n" << endl;
							cout << "Input : ";							
							cin >> type;
							//避免輸入錯誤技能的防呆機制
							while(type!='1'&&type!='2'&&type!='3'&&type!='4'){
								cout << endl;
								cout << "Batman can't use that!!" << endl << endl;
								cout << "Key in number to use the skill: \n";
								cout << "1.Batman Kick  \n2.Batman Punch  \n3.Bat Mobile  \n4.Batman Batarang\n" << endl;
								cout << "Input : ";								
								cin >> type;
							}							
							skill=game.BatmanSkill(type);
							cout << "Batman uses " << skill << " Beats the enemy " << E.Name << "!!!"<< endl;
							game.BatmanLevelUP(E.Lv);
						 	maze[x][y]=' ';
						 	x--;
						 	maze[x][y]='B';
							game.Continue();						 	
						}
					}										
				 	break;
			case 'a':case 'A':
					if(maze[x][y-1]==' '){
					 	maze[x][y]=' ';
					 	y--;
					 	maze[x][y]='B';
					}	
					else if(maze[x][y-1]=='H'||maze[x][y-1]=='R'||maze[x][y-1]=='T'||maze[x][y-1]=='P'||maze[x][y-1]=='J'){
						E=game.EnemyName(maze[x][y-1]);
						cout << "Batman meets enemy: " << E.Name << "   Level: " << E.Lv << endl;
						if(game.BatmanLevel()<=E.Lv){
							cout << "Batman's Level: "<<game.BatmanLevel() << " is under than "<<E.Name <<"'s Level: "<< E.Lv << ",he can't beats " << E.Name <<"." << endl;
							game.Continue();
						}
						else{
							cout << "Key in number to use the skill: \n";
							cout << "1.Batman Kick  \n2.Batman Punch  \n3.Bat Mobile  \n4.Batman Batarang\n" << endl;
							cout << "Input : ";							
							cin >> type;
							//避免輸入錯誤技能的防呆機制
							while(type!='1'&&type!='2'&&type!='3'&&type!='4'){
								cout << endl;
								cout << "Batman can't use that!!" << endl << endl;
								cout << "Key in number to use the skill: \n";
								cout << "1.Batman Kick  \n2.Batman Punch  \n3.Bat Mobile  \n4.Batman Batarang\n" << endl;
								cout << "Input : ";								
								cin >> type;
							}						
							skill=game.BatmanSkill(type);
							cout << "Batman uses " << skill << " Beats the enemy " << E.Name << "!!!"<< endl;
							game.BatmanLevelUP(E.Lv);
						 	maze[x][y]=' ';
						 	y--;
						 	maze[x][y]='B';
						 	game.Continue();
						}
					}									
				 	break;	
			case 'd':case 'D':
					if(maze[x][y+1]==' '){
					 	maze[x][y]=' ';
					 	y++;
					 	maze[x][y]='B';
					}	
					else if(maze[x][y+1]=='H'||maze[x][y+1]=='R'||maze[x][y+1]=='T'||maze[x][y+1]=='P'||maze[x][y+1]=='J'){
						E=game.EnemyName(maze[x][y+1]);
						cout << "Batman meets enemy: " << E.Name << "   Level: " << E.Lv << endl;
						if(game.BatmanLevel()<=E.Lv){
							cout << "Batman's Level: "<<game.BatmanLevel() << " is under than "<<E.Name <<"'s Level: "<< E.Lv << ",he can't beats " << E.Name <<"." << endl;
							game.Continue();
						}
						else{
							cout << "Key in number to use the skill: \n";
							cout << "1.Batman Kick  \n2.Batman Punch  \n3.Bat Mobile  \n4.Batman Batarang\n" << endl;
							cout << "Input : ";
							cin >> type;
							//避免輸入錯誤技能的防呆機制
							while(type!='1'&&type!='2'&&type!='3'&&type!='4'){
								cout << endl;
								cout << "Batman can't use that!!" << endl << endl;
								cout << "Key in number to use the skill: \n";
								cout << "1.Batman Kick  \n2.Batman Punch  \n3.Bat Mobile  \n4.Batman Batarang\n" << endl;
								cout << "Input : ";								
								cin >> type;
							}							
							skill=game.BatmanSkill(type);
							cout << "Batman uses " << skill << " Beats the enemy " << E.Name << "!!!"<< endl;
							game.BatmanLevelUP(E.Lv);
						 	maze[x][y]=' ';
						 	y++;
						 	maze[x][y]='B';
						 	game.Continue();
						}
					}									
				 	break;	
		}
		//將光標移至左上角
		Set();
		for (int i = 0; i<9; i++) {
			puts(maze[i]);
		}			
		//表示抵達出口,退出遊戲
		if(x==8 && y==17){
			break;
		}		
	}
	
	cout << "Batman success escapes the poison room.\n";
	cout << "Batman: I am vengeance !\nI am the night !\nI am Batman !\n";
	system("pause");
}
