//
// Created by Pierre on 13/03/2018.
//

#include <cstdlib>
#include <fstream>
#include "Pi.h"

Pi::Pi(std::string filename, unsigned long long nbDecimal) {

    std::ifstream is(filename);
    if (is) {
        char c;
        is >> c;
        is >> c;
        char *pi = new char[nbDecimal];

        std::cout << "Reading Pi " << nbDecimal<< "...";
        // read data as a block:
        is.read(pi, nbDecimal);

        if (is)
            std::cout << " Done !"<< std::endl;
        else
            std::cout << "error: only " << is.gcount() << " could be read"<<std::endl;
        is.close();


        std::cout << "Finding Phone Number...";
        for (int i = 0; i < nbDecimal; i++) {
            if (pi[i] == '0' && pi[i + 1] != '0') {
                std::string s = "";
                for (int j = i; j < i + 10; j++) {
                    s.push_back(pi[j]);
                }
                char *ch = static_cast<char *>(malloc(sizeof(char)));
                unsigned long temp = std::strtoul(s.c_str(), &ch, 10);
                this->numbers.insert(temp);
                s.clear();
            }
        }
        std::cout << "Done !" << std::endl;
        std::cout << this->numbers.size() << " numbers found" << std::endl;
        delete[](pi);
    }
}

bool Pi::check_number(unsigned long number) {
    return this->numbers.find(number) != this->numbers.end();
}

const std::set<unsigned long> &Pi::getNumbers() const {
    return numbers;
}


int main(){
    Pi p = Pi("../Pi_1B.txt", 1000000000);
    unsigned long t;
    do {
        std::cout << "Enter a number" << std::endl;
        scanf("%lu",&t);
        std::cout << p.check_number(t) << std::endl;
    }while (t>0);
}


