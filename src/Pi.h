//
// Created by Pierre on 13/03/2018.
//

#ifndef PHONE_NUMBER_IN_PI_PI_H
#define PHONE_NUMBER_IN_PI_PI_H

#include <iostream>
#include <cstdio>
#include <set>
#include <vector>
#include <string>

class Pi {

private:
    std::set<unsigned long> numbers;

public:
    Pi(std::string filename, unsigned long long nbDecimal);
    bool check_number(unsigned long number);

    const std::set<unsigned long> &getNumbers() const;
};


#endif //PHONE_NUMBER_IN_PI_PI_H
