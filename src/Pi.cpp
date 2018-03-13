//
// Created by Pierre on 13/03/2018.
//

#include <cstdlib>
#include <fstream>
#include "Pi.h"

Pi::Pi(std::string filename) {

    std::vector<char> pi = std::vector<char>();

    std::ifstream file(filename);
    std::cout << "Reading Pi..." << std::endl;

    char c;
    file >> c;
    file >> c;

    while(!file.eof()){
        file >> c;
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

const std::set<unsigned long> &Pi::getNumbers() const {
    return numbers;
}

int main(){
    Pi p = Pi("../Pi - Dec - Chudnovsky.txt");
    unsigned long t;
    do {
        std::cout << "Enter a number" << std::endl;
        scanf("%lu",&t);
        std::cout << p.check_number(t) << std::endl;
    }while (t>0);

    std::set<unsigned long> numbers = p.getNumbers();
    std::set<unsigned long>::iterator it;

    for(it = numbers.begin(); it!=numbers.end(); ++it)
    {
        std::cout << *it << std::endl;    //On accède à l'élément pointé via l'étoile
    }

}


