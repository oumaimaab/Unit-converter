#include<QApplication>
#include<QPushButton>
#include"mywindow.h"
int main(int argc, char *argv[]){
    QApplication app(argc,argv);
    /*QFont font("Arial");
    QPushButton button("Hello world");
    button.setText("Oumaima");
    button.setFont(QFont("Arial",22,QFont::Bold,true));
    button.setToolTip("This is my name");
    button.setCursor(Qt::PointingHandCursor);
    button.show();
    return app.exec();

    QWidget window;
    window.setFixedSize(300,150);
    QPushButton button("Hello World",&window);
    button.setFont(QFont("Comic Sans Ms",14));
    button.setCursor(Qt::PointingHandCursor);
    button.move(50,50);
    QPushButton button2("Button2",&button);
    window.show();
    return app.exec();*/

    MyWindow window;
    window.show();
    return app.exec();
}
