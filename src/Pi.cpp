//
// Created by Pierre on 13/03/2018.
//

#include <cstdlib>
#include "Pi.h"

Pi::Pi(std::string filename) {

    std::vector<char> pi = std::vector<char>();

    FILE * file = fopen(filename.c_str(),"r");

    std::cout << "Reading Pi..." << std::endl;

    char c;
    fscanf(file,"%c",&c);
    fscanf(file,"%c",&c);
    while(!feof(file) ){
        fscanf(file,"%c",&c);
        pi.push_back(c);
    }
    std::cout << "Done ! " << std::endl;

    std::cout << pi.size() << std::endl;

    std::cout << "Finding Phone Number..." << std::endl;
    for (int i = 0; i < pi.size(); i++) {
        if (pi[i] == '0' && pi[i + 1] != '0') {
            std::string s = "";
            for (int j = i; j < i + 10; j++) {
                s.push_back(pi[j]);
            }
            char * ch = static_cast<char *>(malloc(sizeof(char)));
            unsigned long temp = std::strtoul(s.c_str(),&ch,10);
            this->numbers.insert(temp);
            s.clear();
        }
    }
    std::cout << "Done !" << std::endl;
    std::cout <<this->numbers.size() << " numbers found" << std::endl;
}

bool Pi::check_number(unsigned long number) {
    return this->numbers.find(number) != this->numbers.end();
}

int main(){
    Pi p = Pi("../pi.txt");
    unsigned long t;
    do {
        std::cout << "Enter a number" << std::endl;
        scanf("%lu",&t);
        std::cout << t << std::endl;
        std::cout << p.check_number(t) << std::endl;
    }while (t>=0);

    
}


